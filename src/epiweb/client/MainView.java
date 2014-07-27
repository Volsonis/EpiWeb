package epiweb.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import epiweb.client.service.EpiDBAccessServiceClientImpl;

public class MainView extends Composite
{
  //main panel
  private VerticalPanel mainPanel = new VerticalPanel();
  
  //service
  private EpiDBAccessServiceClientImpl serviceImpl;
  
  //content
  private VerticalPanel contentPanel;
  
  BasicSearchView bsv;
  StaticSearchView ssv;
  AdvancedSearchView asv;
  
  
  public MainView(EpiDBAccessServiceClientImpl serviceImpl)
  {
    initWidget(this.mainPanel); //init main panel
    
    this.serviceImpl = serviceImpl;
    
    
    //create and add menu to the mainView
    MenuView menu = new MenuView(this); //pass reference of itself to menu
    this.mainPanel.add(menu);
    
    //init content panel
    contentPanel = new VerticalPanel();
    mainPanel.add(contentPanel);
    
    //init possible essential contents ( TODO needs to be changed later for parallelisable queries)
    this.bsv = new BasicSearchView(this);
    this.ssv = new StaticSearchView(this);
    this.asv = new AdvancedSearchView(this);
    
  }
  
  //method to access the service in other composites
  public EpiDBAccessServiceClientImpl getService()
  {
    return serviceImpl;
  }
  
  
  
  //method to get the different views (note: has to be changed for parallelisable queries)
  public BasicSearchView getBSV()
  {
    return bsv;
  }
  
  public StaticSearchView getSSV()
  {
    return ssv;
  }
  
  public AdvancedSearchView getASV()
  {
    return asv;
  }
  
  
  ///we need a method for each page that we can open on the main page!
  public void openBasicSearch()
  {
    contentPanel.clear();
    
    if(bsv == null)
      bsv = new BasicSearchView(this);
    
    contentPanel.add(bsv);
  }
  
  public void openStaticSearch()
  {
    contentPanel.clear();
    
    if(ssv == null)
      ssv = new StaticSearchView(this);
    
    contentPanel.add(ssv);
  }
  
  public void openAdvancedSearch()
  {
    contentPanel.clear();
    
    if(asv == null)
      asv = new AdvancedSearchView(this);
    
    contentPanel.add(asv);
  }
  
  public void openHome()
  {
    contentPanel.clear();
    
    //TODO add home view
  }
  
}
