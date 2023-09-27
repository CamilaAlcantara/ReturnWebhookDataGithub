package swap.ReturnWebookDataGithub.Services;


import swap.ReturnWebookDataGithub.Models.ContributorReturnGit;
import swap.ReturnWebookDataGithub.Models.GitHubRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import swap.ReturnWebookDataGithub.Services.Interface.ContribudorServiceInterface;

import java.util.List;

@Service
public class ContributorService implements ContribudorServiceInterface {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<ContributorReturnGit> getContributors(GitHubRequest gitHubRequest) {
        String apiUrl = String.format("https://api.github.com/repos/%s/%s/contributors", gitHubRequest.user , gitHubRequest.repository);
        ResponseEntity<List<ContributorReturnGit>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ContributorReturnGit>>() {}
        );
        return response.getBody();
    }
}
