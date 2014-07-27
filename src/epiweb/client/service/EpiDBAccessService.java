package epiweb.client.service;

import java.sql.SQLException;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import epiweb.client.model.StaticEpiQuery;
import epiweb.client.model.StaticEpiQueryResult;

/* This Interface defines all the services that should be visible to the client */

@RemoteServiceRelativePath("epidbaccessservice")
public interface EpiDBAccessService extends RemoteService
{
  String getCovariateByPMID(String id);
  String getEffectSizeByPMID(String id);
  String getExposureByPMID(String id);
  String getOutcomeByPMID(String id);
  String getPopulationByPMID(String id);
  String getStudyDesignByPMID(String id);
  
  //queries
  List<StaticEpiQueryResult> runStaticQuery(StaticEpiQuery query);
}
