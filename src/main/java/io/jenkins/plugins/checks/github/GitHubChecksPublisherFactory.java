package io.jenkins.plugins.checks.github;

import java.util.Optional;

import org.jenkinsci.plugins.github_branch_source.GitHubSCMSource;

import hudson.Extension;
import hudson.model.Run;

import jenkins.scm.api.SCMSource;

import io.jenkins.plugins.checks.ContextResolver;
import io.jenkins.plugins.checks.api.ChecksPublisher;
import io.jenkins.plugins.checks.api.ChecksPublisherFactory;

@Extension
public class GitHubChecksPublisherFactory extends ChecksPublisherFactory {
    @Override
    protected Optional<ChecksPublisher> createPublisher(final Run<?, ?> run) {
        SCMSource source = new ContextResolver().resolveSource(run);
        return source instanceof GitHubSCMSource ?
                Optional.of(new GitHubChecksPublisher(run)) : Optional.empty();
    }
}
