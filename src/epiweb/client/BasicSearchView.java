package epiweb.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class BasicSearchView extends Composite
{
  private VerticalPanel vPanel = new VerticalPanel();
  
  MainView main;
  
  //content
  //Search Boxes
  private TextBox covariate;
  private TextBox effectSize;
  private TextBox exposure;
  private TextBox outcome;
  private TextBox population;
  private TextBox studyDesign;
  
  //Buttons
  private Button covariateBtn;
  private Button effectSizeBtn;
  private Button exposureBtn;
  private Button outcomeBtn;
  private Button populationBtn;
  private Button studyDesignBtn;
  
  //result 
  private HorizontalPanel resultPanel;
  private Label resultLabel;  
  
  public BasicSearchView(MainView main)
  {
    initWidget(this.vPanel);
    
    this.main = main;
    
    //covariate
    HorizontalPanel covariatePanel = new HorizontalPanel();
    Label covariateLbl = new Label("Covariate: ");
    this.covariate = new TextBox();
    this.covariateBtn = new Button("Search Covariate");
    this.covariateBtn.addClickHandler(new CovariateClickHandler());
    covariatePanel.add(covariateLbl);
    covariatePanel.add(covariate);
    covariatePanel.add(covariateBtn);
    this.vPanel.add(covariatePanel);
    
    //effectSize
    HorizontalPanel effectSizePanel = new HorizontalPanel();
    Label effectSizeLbl = new Label("Effect Size: ");
    this.effectSize = new TextBox();
    this.effectSizeBtn = new Button("Search Effect Size");
    this.effectSizeBtn.addClickHandler(new EffectSizeClickHandler());
    effectSizePanel.add(effectSizeLbl);
    effectSizePanel.add(effectSize);
    effectSizePanel.add(effectSizeBtn);
    this.vPanel.add(effectSizePanel);
    
    //exposure
    HorizontalPanel exposurePanel = new HorizontalPanel();
    Label exposureLbl = new Label("Exposure: ");
    this.exposure = new TextBox();
    this.exposureBtn = new Button("Search Exposure");
    this.exposureBtn.addClickHandler(new ExposureClickHandler());
    exposurePanel.add(exposureLbl);
    exposurePanel.add(exposure);
    exposurePanel.add(exposureBtn);
    this.vPanel.add(exposurePanel);
    
    //outcome
    HorizontalPanel outcomePanel = new HorizontalPanel();
    Label outcomeLbl = new Label("Outcome: ");
    this.outcome = new TextBox();
    this.outcomeBtn = new Button("Search Outcome");
    this.outcomeBtn.addClickHandler(new OutcomeClickHandler());
    outcomePanel.add(outcomeLbl);
    outcomePanel.add(outcome);
    outcomePanel.add(outcomeBtn);
    this.vPanel.add(outcomePanel);
    
    //population
    HorizontalPanel populationPanel = new HorizontalPanel();
    Label populationLbl = new Label("Population: ");
    this.population = new TextBox();
    this.populationBtn = new Button("Search Population");
    this.populationBtn.addClickHandler(new PopulationClickHandler());
    populationPanel.add(populationLbl);
    populationPanel.add(population);
    populationPanel.add(populationBtn);
    this.vPanel.add(populationPanel);
    
    //study design
    HorizontalPanel studyDesignPanel = new HorizontalPanel();
    Label studyDesignLbl = new Label("Study Design: ");
    this.studyDesign = new TextBox();
    this.studyDesignBtn = new Button("Search Study Design");
    this.studyDesignBtn.addClickHandler(new StudyDesignClickHandler());
    studyDesignPanel.add(studyDesignLbl);
    studyDesignPanel.add(studyDesign);
    studyDesignPanel.add(studyDesignBtn);
    this.vPanel.add(studyDesignPanel);
    
    //result
    this.resultPanel = new HorizontalPanel();
    this.resultLabel = new Label("Results will be shown here!");
    this.resultPanel.add(this.resultLabel);
    this.vPanel.add(resultPanel);
    
  }
  
  //method to update results
  public void updateResult(String result)
  {
    resultLabel.setText(result);
  }
  
  //clickhandlers
  private class CovariateClickHandler implements ClickHandler
  {

    @Override
    public void onClick(ClickEvent event)
    {
      String id = covariate.getText(); //get value from textbox
      main.getService().getCovariateByID(id); //send off to service
    }
    
  }
  
  private class EffectSizeClickHandler implements ClickHandler
  {

    @Override
    public void onClick(ClickEvent event)
    {
      String id = effectSize.getText();
      main.getService().getEffectSizeByPMID(id);
      
    }
    
  }
  
  private class ExposureClickHandler implements ClickHandler
  {

    @Override
    public void onClick(ClickEvent event)
    {
      String id = exposure.getText();
      main.getService().getExposureByPMID(id);
      
    }
    
  }
  
  private class OutcomeClickHandler implements ClickHandler
  {

    @Override
    public void onClick(ClickEvent event)
    {
      String id = outcome.getText();
      main.getService().getOutcomeByPMID(id);
      
    }
    
  }
  
  private class PopulationClickHandler implements ClickHandler
  {

    @Override
    public void onClick(ClickEvent event)
    {
      String id = population.getText();
      main.getService().getPopulationByPMID(id);
      
    }
    
  }
  
  private class StudyDesignClickHandler implements ClickHandler
  {

    @Override
    public void onClick(ClickEvent event)
    {
      String id = studyDesign.getText();
      main.getService().getStudyDesignByPMID(id);
      
    }
    
  }
  
}
