package org.ametiste.rest.client;

/**
 * Created by Daria on 27.11.2014.
 */
public interface Representation {

    Representation jump(String rel);

    <E> E exec(Transition<E> rel);

}
