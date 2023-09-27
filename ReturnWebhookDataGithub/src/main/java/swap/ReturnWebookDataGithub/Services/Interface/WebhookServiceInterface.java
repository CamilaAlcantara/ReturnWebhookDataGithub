package swap.ReturnWebookDataGithub.Services.Interface;

import swap.ReturnWebookDataGithub.Models.DataReturnWebhook;
import swap.ReturnWebookDataGithub.Models.GitHubRequest;

import java.util.concurrent.CompletableFuture;

public interface WebhookServiceInterface {
    CompletableFuture<DataReturnWebhook> webhookDataAsync(GitHubRequest gitHubRequest);

    DataReturnWebhook JsonWebhook(GitHubRequest gitHubRequest);
}
