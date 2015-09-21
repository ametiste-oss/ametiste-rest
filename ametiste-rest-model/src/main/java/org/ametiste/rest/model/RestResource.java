package org.ametiste.rest.model;

import org.springframework.hateoas.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daria on 21.07.2014.
 */
public class RestResource<T> {

    private T data;
    private List<Link> links;

    public RestResource(T data) {
        this.links = new ArrayList<>();
        this.data = data;
    }

    public void  addLink(Link link) {
        this.links.add(link);
    }

    public T getData() {
        return this.data;
    }

    public List<Link> getLinks() {
        return this.links;
    }

}
