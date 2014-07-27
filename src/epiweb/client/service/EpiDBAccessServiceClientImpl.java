package epiweb.client.service;

import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import epiweb.client.MainView;
import epiweb.client.model.StaticEpiQuery;
import epiweb.client.model.StaticEpiQueryResult;

/* This class implements the client side code for the service */

public class EpiDBAccessServiceClientImpl implements EpiDBAccessServiceClientInt
{

  private EpiDBAccessServiceAsync service; //allows to make an rpc call, references interface in same package
  
  private MainView mainview; //since clientImpl needs to change the View it should be creating the view
  
  public EpiDBAccessServiceClientImpl(String url)
  {
    //for testing print path
    System.out.println(url);
    
    this.service = GWT.create(EpiDBAccessService.class); //creates service
    ServiceDefTarget endpoint = (ServiceDefTarget) this.service; //derfines this service as a possible "end access point"
    endpoint.setServiceEntryPoint(url);//allow to access service over given url
    
    this.mainview = new MainView(this);
  }
  
  //method to return instance of main view so app can be started
  public MainView getMainView()
  {
    return mainview;
  }
  
  /* identify responses */
  //callback is the mechanism that fires everytime there is a response coming from the server
  //temporary simple response handling (only ids so far) TODO: support other types later
  private class DefaultCallback implements AsyncCallback
  {

    @Override
    public void onFailure(Throwable caught)
    {
      System.out.println("Error fulfilling request: " + caught);
      
    }

    @Override
    public void onSuccess(Object result)
    {
      //temporary fix; TODO: handle datatypes better
      if(result instanceof String)
      {
        String res = (String) result;
        mainview.getBSV().updateResult(res);
      }
      else if(result instanceof List<?>)
      {
        List<StaticEpiQueryResult> res = (List<StaticEpiQueryResult>) result; //may not be possible, need to pack response into string[]
        mainview.getSSV().updateResult(res);
      }
      
    }
    
  }

  
  /* invoke server side implementation */
  @Override
  public void getCovariateByID(String id)
  {
    this.service.getCovariateByPMID(id, new DefaultCallback());// after all the setup above, the service is now available in the client here 
  }
  
  @Override
  public void getEffectSizeByPMID(String id)
  {
    this.service.getEffectSizeByPMID(id, new DefaultCallback());
    
  }

  @Override
  public void getExposureByPMID(String id)
  {
    this.service.getExposureByPMID(id, new DefaultCallback());
    
  }

  @Override
  public void getOutcomeByPMID(String id)
  {
    this.service.getOutcomeByPMID(id, new DefaultCallback());
    
  }

  @Override
  public void getPopulationByPMID(String id)
  {
    this.service.getPopulationByPMID(id, new DefaultCallback());
    
  }

  @Override
  public void getStudyDesignByPMID(String id)
  {
    this.service.getStudyDesignByPMID(id, new DefaultCallback());
    
  }

  /* static Query */
  @Override
  public void runStaticQuery(StaticEpiQuery query)
  {
    this.service.runStaticQuery(query, new DefaultCallback());
  }

}
