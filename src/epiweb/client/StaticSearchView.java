package epiweb.client;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import epiweb.client.model.StaticEpiQuery;
import epiweb.client.model.StaticEpiQueryResult;

public class StaticSearchView extends Composite
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
  private Button searchBtn;
  
  //result 
  private HorizontalPanel resultPanel;
  //TODO add scrollable/pageturnable results table
  private ResultTable resultTable;
  
  private Grid resultGrid;
  
  public StaticSearchView(MainView main)
  {
    initWidget(this.vPanel);
    
    this.main = main;
    
    //covariate
    HorizontalPanel covariatePanel = new HorizontalPanel();
    Label covariateLbl = new Label("Covariate: ");
    this.covariate = new TextBox();
    covariatePanel.add(covariateLbl);
    covariatePanel.add(covariate);
    this.vPanel.add(covariatePanel);
    
    //effectSize
    HorizontalPanel effectSizePanel = new HorizontalPanel();
    Label effectSizeLbl = new Label("Effect Size: ");
    this.effectSize = new TextBox();
    effectSizePanel.add(effectSizeLbl);
    effectSizePanel.add(effectSize);
    this.vPanel.add(effectSizePanel);
    
    //exposure
    HorizontalPanel exposurePanel = new HorizontalPanel();
    Label exposureLbl = new Label("Exposure: ");
    this.exposure = new TextBox();
    exposurePanel.add(exposureLbl);
    exposurePanel.add(exposure);
    this.vPanel.add(exposurePanel);
    
    //outcome
    HorizontalPanel outcomePanel = new HorizontalPanel();
    Label outcomeLbl = new Label("Outcome: ");
    this.outcome = new TextBox();
    outcomePanel.add(outcomeLbl);
    outcomePanel.add(outcome);
    this.vPanel.add(outcomePanel);
    
    //population
    HorizontalPanel populationPanel = new HorizontalPanel();
    Label populationLbl = new Label("Population: ");
    this.population = new TextBox();
    populationPanel.add(populationLbl);
    populationPanel.add(population);
    this.vPanel.add(populationPanel);
    
    //study design
    HorizontalPanel studyDesignPanel = new HorizontalPanel();
    Label studyDesignLbl = new Label("Study Design: ");
    this.studyDesign = new TextBox();
    studyDesignPanel.add(studyDesignLbl);
    studyDesignPanel.add(studyDesign);
    this.vPanel.add(studyDesignPanel);
    
    //search button
    HorizontalPanel searchBtnPanel = new HorizontalPanel();
    this.searchBtn = new Button("Search");
    this.searchBtn.addClickHandler(new SearchBtnClickHandler());
    searchBtnPanel.add(searchBtn);
    this.vPanel.add(searchBtnPanel);
    
    //result display
    resultPanel = new HorizontalPanel();
    //add table (grid)
    /*
    this.resultGrid = new Grid(1,3);
    resultGrid.setWidget(0, 0, new Label("PMID")); //format: PMid | Year | Title
    resultGrid.setWidget(0, 1, new Label("Year"));
    resultGrid.setWidget(0, 2, new Label("Title"));
    
    this.resultPanel.add(resultGrid);
    */
    //TODO add CellTable
    
    
    this.vPanel.add(resultPanel);
    
  }
  
  //method to update results
  public void updateResult(List<StaticEpiQueryResult> result)
  {
    resultPanel.clear();
    
    //TODO implement result display
    if (resultTable == null)
      resultTable = new ResultTable(result);
    else
    {
      //resultPanel.clear();
      //TODO resultTable.update();
    }
    
    this.resultPanel.add(resultTable);
    //update table
  }
  
  
  private class SearchBtnClickHandler implements ClickHandler
  {

    @Override
    public void onClick(ClickEvent event)
    {
      //compile the query from the fields
      StaticEpiQuery query = new StaticEpiQuery(covariate.getText(), effectSize.getText(), exposure.getText(), outcome.getText(), population.getText(), studyDesign.getText());
      main.getService().runStaticQuery(query);
    }
    
  }
  
}
