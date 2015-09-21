package org.ametiste.rest.model;

import java.util.Collection;

/**
 * Created by Daria on 21.07.2014.
 */
public class ResourceCollection<T> {


    private final Collection<RestResource<T>> content;

    public ResourceCollection(Collection<RestResource<T>> allSources) {

        content = allSources;

    }

    public Collection<RestResource<T>> getContent() {

        return content;
    }
}
