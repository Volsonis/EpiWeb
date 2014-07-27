package epiweb.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class MenuView extends Composite
{
  //menu panel
  private HorizontalPanel menuPanel = new HorizontalPanel();
  
  //connection to mainview so we can interact with it
  private MainView main;
  
  //global buttons
  private Button homeBtn;
  private Button basicSearchBtn;
  private Button staticSearchBtn;
  private Button advancedSearchBtn;
  
  //constructor
  public MenuView(MainView main)
  {
    initWidget(this.menuPanel);
    
    this.main = main;
    
    
    //define buttons
    this.homeBtn = new Button("Home");
    this.basicSearchBtn = new Button("PMID Search");
    this.staticSearchBtn = new Button("Static Search");
    this.advancedSearchBtn = new Button("Advanced Search");
    
    
    //add listeners
    this.homeBtn.addClickHandler(new HomeBtnClickHandler());
    this.basicSearchBtn.addClickHandler(new BasicSearchBtnClickHandler());
    this.staticSearchBtn.addClickHandler(new StaticSearchBtnClickHandler());
    this.advancedSearchBtn.addClickHandler(new AdvancedSearchBtnClickHandler());
    
    
    //add buttons
    this.menuPanel.add(homeBtn);
    this.menuPanel.add(basicSearchBtn);
    this.menuPanel.add(staticSearchBtn);
    this.menuPanel.add(advancedSearchBtn);
    
  }
  
  
  
  //click handlers
  private class HomeBtnClickHandler implements ClickHandler
  {

    @Override
    public void onClick(ClickEvent event)
    {
      main.openHome(); 
    }   
  }//class class HomeBtnClickHandler
  
  private class BasicSearchBtnClickHandler implements ClickHandler
  {

    @Override
    public void onClick(ClickEvent event)
    {
      main.openBasicSearch();
    }  
  }//class BasicSearchBtnClickHandler
  
  private class StaticSearchBtnClickHandler implements ClickHandler
  {

    @Override
    public void onClick(ClickEvent event)
    {
      main.openStaticSearch(); 
    }   
  }//class class StaticSearchBtnClickHandler
  
  private class AdvancedSearchBtnClickHandler implements ClickHandler
  {

    @Override
    public void onClick(ClickEvent event)
    {
      main.openAdvancedSearch(); 
    }   
  }//class class AdvancedSearchBtnClickHandler
  
}//class MenuView
