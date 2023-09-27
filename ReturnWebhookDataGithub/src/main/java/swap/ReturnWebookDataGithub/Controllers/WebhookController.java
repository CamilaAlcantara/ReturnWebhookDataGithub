package swap.ReturnWebookDataGithub.Controllers;

import swap.ReturnWebookDataGithub.Models.DataReturnWebhook;
import swap.ReturnWebookDataGithub.Models.GitHubRequest;
import swap.ReturnWebookDataGithub.Services.Interface.WebhookServiceInterface;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("webhook")
public class WebhookController {

    private WebhookServiceInterface webhookServiceInterface;
    public WebhookController(WebhookServiceInterface webhookServiceInterface){
        this.webhookServiceInterface = webhookServiceInterface;
    }
    @GetMapping("/")
    public CompletableFuture<DataReturnWebhook> webhook(@RequestParam String user,
                                                        @RequestParam String repository){
        GitHubRequest gitHubRequest =  new GitHubRequest();
        gitHubRequest.user = user;
        gitHubRequest.repository = repository;

        return  webhookServiceInterface.webhookDataAsync(gitHubRequest);
    }
    @GetMapping("/send-webhook")
    public void sendWebhook(@RequestParam String linkUrl) throws UnsupportedEncodingException {
        GitHubRequest gitHubRequest =  new GitHubRequest();
        gitHubRequest.user = "CamilaAlcantara";
        gitHubRequest.repository = "meta";

        String url =  URLDecoder.decode(linkUrl, "UTF-8");

        RestTemplate restTemplate = new RestTemplate();
        DataReturnWebhook dataReturnWebhook = webhookServiceInterface.JsonWebhook(gitHubRequest);
        restTemplate.postForObject(url, dataReturnWebhook, DataReturnWebhook.class);
    }

}
