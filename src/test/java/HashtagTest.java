import com.google.gson.JsonObject;
import helpers.ApiHelper;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.ImageBrowserPage;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class HashtagTest extends TestBase {


    @Test
    public void uploadPhotoWithHashtag() throws IOException {
        JsonObject photo = ApiHelper.uploadPhoto(key);
        String imageId = photo.getAsJsonPrimitive("id").getAsString();
        ApiHelper.editPhoto(key, "#hashtag_changed", imageId);
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage(imageId);
        assertTrue(imageBrowserPage.isHashtagChanged(), "Hashtag not changed");
    }
}