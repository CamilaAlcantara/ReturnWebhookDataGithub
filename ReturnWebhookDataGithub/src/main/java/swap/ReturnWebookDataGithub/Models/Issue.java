package swap.ReturnWebookDataGithub.Models;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Issue {

    public String title;

    public String user;
    public List<String> labels;
}
