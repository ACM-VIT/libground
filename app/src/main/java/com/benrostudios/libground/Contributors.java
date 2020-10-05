package com.benrostudios.libground;

public class Contributors {

    private String contributorsName, contributorsGithubID, contributorsLinkedInID;

    public Contributors(String contributorsName, String contributorsGithubID, String contributorsLinkedInID) {
        this.contributorsName = contributorsName;
        this.contributorsGithubID = contributorsGithubID;
        this.contributorsLinkedInID = contributorsLinkedInID;
    }

    public String getContributorsName() {
        return contributorsName;
    }

    public void setContributorsName(String contributorsName) {
        this.contributorsName = contributorsName;
    }

    public String getContributorsGithubID() {
        return contributorsGithubID;
    }

    public void setContributorsGithubID(String contributorsGithubID) {
        this.contributorsGithubID = contributorsGithubID;
    }

    public String getContributorsLinkedInID() {
        return contributorsLinkedInID;
    }

    public void setContributorsLinkedInID(String contributorsLinkedInID) {
        this.contributorsLinkedInID = contributorsLinkedInID;
    }
}

