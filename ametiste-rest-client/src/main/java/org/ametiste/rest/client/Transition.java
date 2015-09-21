package org.ametiste.rest.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

/**
 * Created by Daria on 27.11.2014.
 */
public interface Transition<T> {

    MediaType getMediaType();

    HttpMethod getMethod();

    Class<T> getResponseType();

    String getRelation();
}
