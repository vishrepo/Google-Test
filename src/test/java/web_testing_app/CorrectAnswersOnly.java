/*

//Ques-3
try {
			shortWait.until(ExpectedConditions.elementToBeClickable(By.id("knowledge-verticals-internetspeedtest__test_button")));
		} catch (TimeoutException ex) {
			fail("\"RUN SPEED TEST\" button not found.");
		}
//Ques- 5
 try {
			shortWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//g-raised-button[@jsaction=\'dArJMd\']")));
		} catch (TimeoutException ex) {
			fail("\"CANCEL\" button not found.");
		}
 

//Ques -6
longWait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath("//g-raised-button[@jsaction=\'dArJMd\']"))));

//Ques -7
shortWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//g-raised-button[@jsaction=\'iyDKIb\']")));

//Ques -8  // For Line of code  for full code use Name
shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//g-raised-button[@jsaction=\'i0JLwd\']")));

//Ques 26
 driver.findElement(By.xpath("//div[@jsname=\'rk7bOd\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "7"));
		} catch (TimeoutException ex) {
			fail("\"7\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'lVjWed\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "72"));
		} catch (TimeoutException ex) {
			fail("\"2\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'WxTTNd\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "72 ÷"));
		} catch (TimeoutException ex) {
			fail("\"÷\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'N10B9\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "72 ÷ 1"));
		} catch (TimeoutException ex) {
			fail("\"1\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'bkEvMb\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "72 ÷ 10"));
		} catch (TimeoutException ex) {
			fail("\"0\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'Pt8tGc\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "7.2"));
		} catch (TimeoutException ex) {
			fail("\"7.2\" was not the solution.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'SLn8gc\']")).click();
														
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "0"));
		} catch (TimeoutException ex) {
			fail("Output not cleared to \"0\".");
		}
 

//Ques -27
driver.findElement(By.xpath("//div[@jsname=\'DfiOAc\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log("));
		} catch (TimeoutException ex) {
			fail("\"log()\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'Ax5wH\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(5"));
		} catch (TimeoutException ex) {
			fail("\"5\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'T7PMFe\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58"));
		} catch (TimeoutException ex) {
			fail("\"8\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'YovRWb\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58 ×"));
		} catch (TimeoutException ex) {
			fail("\"×\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'abcgof\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58 × 6"));
		} catch (TimeoutException ex) {
			fail("\"6\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'WxTTNd\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58 × 6 ÷"));
		} catch (TimeoutException ex) {
			fail("\"÷\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'lVjWed\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58 × 6 ÷ 2"));
		} catch (TimeoutException ex) {
			fail("\"2\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'pPHzQc\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58 × 6 ÷ 2 -"));
		} catch (TimeoutException ex) {
			fail("\"-\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'rk7bOd\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58 × 6 ÷ 2 - 7"));
		} catch (TimeoutException ex) {
			fail("\"7\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'xAP7E\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58 × 6 ÷ 2 - 74"));
		} catch (TimeoutException ex) {
			fail("\"4\" was not input.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'Pt8tGc\']")).click();
												
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "2"));
		} catch (TimeoutException ex) {
			fail("\"2\" was not the solution.");
		}
		
		driver.findElement(By.xpath("//div[@jsname=\'SLn8gc\']")).click();
														
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "0"));
		} catch (TimeoutException ex) {
			fail("Output not cleared to \"0\".");
		}

//Ques -39
driver.findElement(By.cssSelector("div[jsname=\'rk7bOd\']")).click();
		
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'7\']"));
		} catch (NoSuchElementException ex) {
			fail("\"7\" was not input.");
		}
		
		driver.findElement(By.cssSelector("div[jsname=\'lVjWed\']")).click();
		
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'72\']"));
		} catch (NoSuchElementException ex) {
			fail("\"2\" was not input.");
		}
		
		driver.findElement(By.cssSelector("div[jsname=\'WxTTNd\']")).click();
		
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'72 ÷ \']"));
		} catch (NoSuchElementException ex) {
			fail("\"÷\" was not input.");
		}
		
		driver.findElement(By.cssSelector("div[jsname=\'N10B9\']")).click();
		
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'72 ÷ 1\']"));
		} catch (NoSuchElementException ex) {
			fail("\"1\" was not input.");
		}
		
		driver.findElement(By.cssSelector("div[jsname=\'bkEvMb\']")).click();
		
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'72 ÷ 10\']"));
		} catch (NoSuchElementException ex) {
			fail("\"0\" was not input.");
		}
		
		driver.findElement(By.cssSelector("div[jsname=\'Pt8tGc\']")).click();
		
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'7.2\']"));
		} catch (NoSuchElementException ex) {
			fail("\"7.2\" was not the solution.");
		}
		
		
		driver.findElement(By.cssSelector("div[jsname=\'SLn8gc\']")).click();
		
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'0\']"));
		} catch (NoSuchElementException ex) {
			fail("Output not cleared to \"0\".");
		}

//Ques -40
driver.findElement(By.cssSelector("div[jsname=\'DfiOAc\']")).click();
	    try {
	      driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(\']"));
	    } catch (NoSuchElementException ex) {
	        fail("\"log\" was not input.");
	    }
 driver.findElement(By.cssSelector("div[jsname=\'Ax5wH\']")).click();
	    try {
driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(5\']"));
	    } catch (NoSuchElementException ex) {
	        fail("\"5\" was not input.");
	    }
  driver.findElement(By.cssSelector("div[jsname=\'T7PMFe\']")).click();
	    try {
 driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58\']"));
	    } catch (NoSuchElementException ex) {
	        fail("\"8\" was not input.");
	    }
 driver.findElement(By.cssSelector("div[jsname=\'YovRWb\']")).click();
	    try {
 driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58 × \']"));
	    } catch (NoSuchElementException ex) {
	        fail("\"×\" was not input.");
	    }
 driver.findElement(By.cssSelector("div[jsname=\'abcgof\']")).click();
	    try {
 driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58 × 6\']"));
	    } catch (NoSuchElementException ex) {
	        fail("\"6\" was not input.");
	    }
 driver.findElement(By.cssSelector("div[jsname=\'WxTTNd\']")).click();
	    try {
driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58 × 6 ÷ \']"));
	    } catch (NoSuchElementException ex) {
	        fail("\"÷\" was not input.");
	    }
 driver.findElement(By.cssSelector("div[jsname=\'lVjWed\']")).click();
	    try {
driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58 × 6 ÷ 2\']"));
	    } catch (NoSuchElementException ex) {
	        fail("\"2\" was not input.");
	    }
driver.findElement(By.cssSelector("div[jsname=\'pPHzQc\']")).click();
	    try {
driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58 × 6 ÷ 2 - \']"));
	    } catch (NoSuchElementException ex) {
	        fail("\"-\" was not input.");
	    }
driver.findElement(By.cssSelector("div[jsname=\'rk7bOd\']")).click();
	    try {
driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58 × 6 ÷ 2 - 7\']"));
	    } catch (NoSuchElementException ex) {
	        fail("\"7\" was not input.");
	    }
driver.findElement(By.cssSelector("div[jsname=\'xAP7E\']")).click();
	    try {
driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58 × 6 ÷ 2 - 74\']"));
	    } catch (NoSuchElementException ex) {
	        fail("\"4\" was not input.");
	    }
 driver.findElement(By.cssSelector("div[jsname=\'Pt8tGc\']")).click();
	    try {
 driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'2\']"));
	    } catch (NoSuchElementException ex) {
	        fail("\"2\" was not the solution.");
	    }
driver.findElement(By.cssSelector("div[jsname=\'SLn8gc\']")).click();
	    try {
driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'0\']"));
	    } catch (NoSuchElementException ex) {
	        fail("Output not cleared to \"0\".");
	    }
 try {
	        TimeUnit.SECONDS.sleep(5);
	    } catch (InterruptedException e) {
	    	
	    }
*/