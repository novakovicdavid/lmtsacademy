package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

public class Event {



        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_generator")

        @SequenceGenerator(name = "event_generator", sequenceName = "event_seq", allocationSize = 1)

        private Integer id;

        private String title;
        private String description;
        private LocalDateTime start;
        private LocalDateTime finish;

        public Event(Integer id, String title, String description, LocalDateTime start, LocalDateTime finish) {
            super();
            this.id = id;
            this.title = title;
            this.description = description;
            this.start = start;
            this.finish = finish;
        }

        public Event() {
            super();

        }


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public LocalDateTime getStart() {
            return start;
        }

        public void setStart(LocalDateTime start) {
            this.start = start;
        }

        public LocalDateTime getFinish() {
            return finish;
        }

        public void setFinish(LocalDateTime finish) {
            this.finish = finish;
        }

        @Override
        public String toString() {
            return "Event [id=" + id + ", title=" + title + ", description=" + description + ", start=" + start
                    + ", finish=" + finish + "]";
        }
    }

