package org.ametiste.rest.client.leap;

import org.springframework.hateoas.Link;

import java.util.List;

/**
 * Created by Daria on 27.11.2014.
 */
public class ShapelessData {

    private Object data;
    private List<Link> links;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
