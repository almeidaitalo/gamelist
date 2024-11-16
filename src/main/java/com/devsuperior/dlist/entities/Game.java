package com.devsuperior.dlist.entities;

public class Games {

      private Long id;
      private String title;
      private Integer year;
      private String genre;
      private String platform;
      private String imgUrl;
      private String shortDescription;
      private String longDescription;


      public Games() {
      }

    public Games(Long id) {
        this.id = id;
    }
}
