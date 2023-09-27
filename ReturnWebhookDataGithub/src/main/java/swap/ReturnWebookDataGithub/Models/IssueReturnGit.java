package swap.ReturnWebookDataGithub.Models;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IssueReturnGit {

    public String title;

    public UserReturnGit user;

    public List<LabelReturnGit> labels;

}
