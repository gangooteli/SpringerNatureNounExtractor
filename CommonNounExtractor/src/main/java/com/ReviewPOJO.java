package main.java.com;

import java.util.ArrayList;

public class ReviewPOJO {

	private String reviewerID;

	  public String getReviewerID() { return this.reviewerID; }

	  public void setReviewerID(String reviewerID) { this.reviewerID = reviewerID; }

	  private String asin;

	  public String getAsin() { return this.asin; }

	  public void setAsin(String asin) { this.asin = asin; }

	  private String reviewerName;

	  public String getReviewerName() { return this.reviewerName; }

	  public void setReviewerName(String reviewerName) { this.reviewerName = reviewerName; }

	  private ArrayList<Integer> helpful;

	  public ArrayList<Integer> getHelpful() { return this.helpful; }

	  public void setHelpful(ArrayList<Integer> helpful) { this.helpful = helpful; }

	  private String reviewText;

	  public String getReviewText() { return this.reviewText; }

	  public void setReviewText(String reviewText) { this.reviewText = reviewText; }

	  private double overall;

	  public double getOverall() { return this.overall; }

	  public void setOverall(double overall) { this.overall = overall; }

	  private String summary;

	  public String getSummary() { return this.summary; }

	  public void setSummary(String summary) { this.summary = summary; }

	  private int unixReviewTime;

	  public int getUnixReviewTime() { return this.unixReviewTime; }

	  public void setUnixReviewTime(int unixReviewTime) { this.unixReviewTime = unixReviewTime; }

	  private String reviewTime;

	  public String getReviewTime() { return this.reviewTime; }

	  public void setReviewTime(String reviewTime) { this.reviewTime = reviewTime; }
}
