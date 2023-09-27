package swap.ReturnWebookDataGithub.Services;

import swap.ReturnWebookDataGithub.Models.GitHubRequest;
import swap.ReturnWebookDataGithub.Models.IssueReturnGit;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import swap.ReturnWebookDataGithub.Services.Interface.IssueServiceInterface;

import java.time.LocalDate;
import java.util.List;
@Service
public class IssueService implements IssueServiceInterface {

    private final RestTemplate restTemplate = new RestTemplate();
    private final LocalDate dataRequisicao;
    public IssueService() {
        this.dataRequisicao = LocalDate.now().minusDays(1);
    }
    @Override
    public List<IssueReturnGit> getIssues(GitHubRequest gitHubRequest) {
        String apiUrl = String.format("https://api.github.com/repos/"+ gitHubRequest.user +"/"+ gitHubRequest.repository + "/issues?since=" + dataRequisicao);
        ResponseEntity<List<IssueReturnGit>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<IssueReturnGit>>() {}
        );
        return response.getBody();
    }
}
