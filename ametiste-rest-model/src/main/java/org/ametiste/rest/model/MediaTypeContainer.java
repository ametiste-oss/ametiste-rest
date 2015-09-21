package org.ametiste.rest.model;

/**
 * Created by Daria on 21.07.2014.
 *
 */
//TODO move it from here to mda
public enum MediaTypeContainer {

    SOURCELIST( "application/vnd.ametiste.mda.source-page+json"),
	SOURCE("application/vnd.ametiste.mda.source+json");
	

    private final String name;

    MediaTypeContainer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
