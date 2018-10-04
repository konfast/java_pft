package ru.stqa.pft.rest.appmanager;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import ru.stqa.pft.rest.tests.Issue;
import java.io.IOException;
import java.util.Set;

public class RestHelper {

  private ApplicationManager app;
  public RestHelper (ApplicationManager app) {
    this.app = app;
  }

  public Issue getIssue(int issueId) throws IOException {
    String json = getExecutor().execute(Request.Get(String.format("http://bugify.stqa.ru/api/issues/%s.json", issueId))).
            returnContent().asString();
    System.out.println(json);
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issue = parsed.getAsJsonObject().get("issues").getAsJsonArray().get(0);
    return new Gson().fromJson(issue, Issue.class);

  }

  public Set<Issue> getIssues() throws IOException {
    String json = getExecutor().execute(Request.Get("http://bugify.stqa.ru/api/issues.json")).
            returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());

  }

  private Executor getExecutor() {
    return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");

  }
}
