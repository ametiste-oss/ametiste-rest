package org.ametiste.rest.utils.builder;

import org.springframework.hateoas.core.LinkBuilderSupport;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by Daria on 21.07.2014.
 */
public class SimpleLinkBuilder extends LinkBuilderSupport<SimpleLinkBuilder> {


    /**
     * Creates a new {@link org.springframework.hateoas.core.LinkBuilderSupport} using the given {@link org.springframework.web.util.UriComponentsBuilder}.
     *
     * @param builder must not be {@literal null}.
     */
    private SimpleLinkBuilder(UriComponentsBuilder builder) {
        super(builder);
    }

    @Override
    protected SimpleLinkBuilder getThis() {
        return this;
    }

    @Override
    protected SimpleLinkBuilder createNewInstance(UriComponentsBuilder builder) {
        return new SimpleLinkBuilder(builder);
    }

    public static SimpleLinkBuilder createBuilderFromUri(String uri) {
        return new SimpleLinkBuilder(UriComponentsBuilder.fromUriString(uri));

    }

}
