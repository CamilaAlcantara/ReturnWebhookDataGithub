package swap.ReturnWebookDataGithub.Services;


import swap.ReturnWebookDataGithub.Models.UserReturnGit;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import swap.ReturnWebookDataGithub.Services.Interface.UserServiceInterface;


@Service
public class UserService implements UserServiceInterface {
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public UserReturnGit getUser(String user) {
        String apiUrl = String.format("https://api.github.com/users/"+ user);
        ResponseEntity<UserReturnGit> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<UserReturnGit>() {}
        );
        return response.getBody();
    }
}
