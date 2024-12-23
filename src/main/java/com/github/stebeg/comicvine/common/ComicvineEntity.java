package com.github.stebeg.comicvine.common;

/**
 * The default interface for all entities read from the Comicvine API.
 */
public interface ComicvineEntity {

  /**
   * Retrieves the unique ID of the entity.
   *
   * @return The unique ID of the entity.
   */
  long getId();

  /**
   * Retrieves the name of the entity.
   *
   * @return The name of the entity.
   */
  String getName();

}
