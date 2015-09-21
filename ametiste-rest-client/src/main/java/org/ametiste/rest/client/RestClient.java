package org.ametiste.rest.client;

/**
 * Created by Daria on 27.11.2014.
 */
public interface RestClient {

    Representation root();
    <T> T execRoot(Transition<T> rel);
}
