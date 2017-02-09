package com.adneom.kdevillard.pocmosby.mvp.model;

import java.util.Locale;

/**
 * Created by kdevillard on 24-11-16.
 */

public class GitHubMember {
    public String login;
    public int followers;

    @Override
    public String toString() {
        return String.format(Locale.US, "%s: %d followers", login, followers);
    }
}
