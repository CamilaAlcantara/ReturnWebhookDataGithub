package swap.ReturnWebookDataGithub.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DataReturnWebhook {

    private String user;
    private String repository;
    private List<Issue> issues;
    private List<Contributor> contributors;

    public DataReturnWebhook(String user, String repository, List<Issue> issues ,List<Contributor> contributors ){
        this.user = user;
        this.repository = repository;
        this.issues = issues;
        this.contributors = contributors;

    }
}
