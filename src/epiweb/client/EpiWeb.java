package epiweb.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

import epiweb.client.service.EpiDBAccessServiceClientImpl;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EpiWeb implements EntryPoint
{

  /**
   * This is the entry point method.
   */
  public void onModuleLoad()
  {
    //create instance of clientImpl here which will instantiate UI
    EpiDBAccessServiceClientImpl clientImpl = new EpiDBAccessServiceClientImpl(GWT.getModuleBaseURL() + "epidbaccessservice"); //so client is always able to find correct path to the service
    
    RootPanel.get().add(clientImpl.getMainView());
  }
}
