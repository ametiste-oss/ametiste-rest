package org.ametiste.rest.client.leap;


import org.ametiste.rest.client.Representation;
import org.ametiste.rest.client.Transition;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daria on 27.11.2014.
 */
public class LeapRepresentation implements Representation {

    private Map<String, String> relationToUri;
    private RestTemplate rt;
    private MediaType type;

    public LeapRepresentation(ShapelessData data, MediaType defaultJumpType, RestTemplate rt) {
        this.type = defaultJumpType;
        this.rt = rt;
        relationToUri = new HashMap<>();
        for(Link link: data.getLinks()) {
            relationToUri.put(link.getRel(), link.getHref());
        }

    }

    @Override
    public Representation jump(String rel) {
        if(!relationToUri.containsKey(rel)) {
            throw new IllegalArgumentException("No such relation in representation");
        }

        Transition<ShapelessData> t = buildLeap(rel);

        ShapelessData data = this.load(t, relationToUri.get(rel));

       return new LeapRepresentation(data, this.type, rt);
    }

    private Transition<ShapelessData> buildLeap(final String relation) {
        return new Transition<ShapelessData>() {

            @Override
            public MediaType getMediaType() {
                return type;
            }

            @Override
            public HttpMethod getMethod() {
                return HttpMethod.GET;
            }

            @Override
            public Class<ShapelessData> getResponseType() {
                return ShapelessData.class;
            }

            @Override
            public String getRelation() {
                return relation;
            }
        };
    }

    @Override
    public <E> E exec(Transition<E> rel) {

        if(!relationToUri.containsKey(rel.getRelation())) {
            throw new IllegalArgumentException("No such relation in representation");
        }

        String href = relationToUri.get(rel.getRelation());
        E reply = load(rel, href);

        return reply;
    }

    private <E> E load(Transition<E> rel, String href) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(rel.getMediaType()));

        HttpEntity entity = new HttpEntity(headers);

        return rt.exchange(href, rel.getMethod(), entity, rel.getResponseType()).getBody();
    }
}
