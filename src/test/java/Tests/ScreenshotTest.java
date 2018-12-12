/*
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package Tests;

import java.io.File;
import Tests.AbstractBaseTests.TestBase;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Test.
 */
public class ScreenshotTest extends TestBase {

    private final String TEST_URL = "https://game.auone.jp/";

    @Test
    public void testScreenshot() throws InterruptedException {

		// Thread.sleep(3000);
		driver.get(TEST_URL);
		Thread.sleep(3000);
	
		// This will store the screenshot under /tmp on your local machine
		String screenshotDir = System.getProperty("appium.screenshots.dir", System.getProperty("java.io.tmpdir", ""));
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenshot.renameTo(new File(screenshotDir, "augame.png"));
//		WebElement element = driver.findElement(By.cssSelector("a.slick-slide.slick-active"));
		WebElement element = driver.findElement(By.cssSelector("a.banner-list__link-item"));
		element.click();
		Thread.sleep(3000);
		File screenshot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenshot2.renameTo(new File(screenshotDir, "gamegift.png"));
		Thread.sleep(3000);
    }
}
