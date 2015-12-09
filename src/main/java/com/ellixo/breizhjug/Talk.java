package com.ellixo.breizhjug;

import org.springframework.data.annotation.Id;

public class Talk {

    @Id
    private String id;

    private String titre;
    private String description;
    private String speaker;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Talk talk = (Talk) o;

        if (titre != null ? !titre.equals(talk.titre) : talk.titre != null) return false;
        if (description != null ? !description.equals(talk.description) : talk.description != null) return false;
        return !(speaker != null ? !speaker.equals(talk.speaker) : talk.speaker != null);

    }

    @Override
    public int hashCode() {
        int result = titre != null ? titre.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (speaker != null ? speaker.hashCode() : 0);
        return result;
    }
}
