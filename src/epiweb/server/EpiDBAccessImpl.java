package epiweb.server;

import java.sql.SQLException;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import epiweb.server.epidb.*;
import epiweb.client.model.StaticEpiQuery;
import epiweb.client.model.StaticEpiQueryResult;
import epiweb.client.service.EpiDBAccessService;

/* server side implementation needs to extend RemoteServiceServlet
 * so it can host the services
 * 
 * and implements interface from the client to make sure they implement the same methods
 * 
 */

public class EpiDBAccessImpl extends RemoteServiceServlet implements EpiDBAccessService
{

  private String result = "Error while searching entry!";
  
  @Override
  public String getCovariateByPMID(String id)
  {
    //get the row where pmid = what is passed
    CovariateTable.Row row = null;
    try
    {
      row = CovariateTable.getRow("pmid", id);
      
      //turn the result into a string
      if(row != null)
        result = "PMID: " + row.getPmid() + 
                      "\nCovariate: " + row.getCovariate() + 
                      "\nOther_covariate: " + row.getOther_covariate() + 
                      "\nUMLS_category: " + row.getUmls_category() + 
                      "\nUMLSs_group: " + row.getUmls_group() + 
                      "\nYear: " + row.getYear() + "\n";
      else
        result = "No covariate entry found for PMID " + id;
      
    } catch (SQLException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return result;
  }

  @Override
  public String getEffectSizeByPMID(String id)
  {
    Effect_sizeTable.Row row = null;
    try
    {
      row = Effect_sizeTable.getRow("pmid", id);
      
      //turn the result into a string
      if(row != null)
        result = "PMID: " + row.getPmid() + 
                      "\nEffect Size CI: " + row.getEffect_size_ci() + 
                      "\nEffect Size Concept: " + row.getEffect_size_concept() + 
                      "\nEffect Size Number: " + row.getEffect_size_number() + 
                      "\nEffect Size Type: " + row.getEffect_size_type() + 
                      "\nYear: " + row.getYear() + "\n";
      else
        result = "No effect size entry found for PMID " + id;
      
    } catch (SQLException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return result;
  }

  @Override
  public String getExposureByPMID(String id)
  {
    ExposureTable.Row row = null;
    try
    {
      row = ExposureTable.getRow("pmid", id);
      
      //turn the result into a string
      if(row != null)
        result = "PMID: " + row.getPmid() + 
                      "\nExposure: " + row.getExposure() + 
                      "\nOther_Exposure: " + row.getOther_exposure() + 
                      "\nUMLS_category: " + row.getUmls_category() + 
                      "\nUMLS_group: " + row.getUmls_group() + 
                      "\nYear: " + row.getYear() + "\n";
      else
        result = "No exposure entry found for PMID " + id;
      
    } catch (SQLException e)
    {
      
      e.printStackTrace();
    }
    
    return result;
  }

  @Override
  public String getOutcomeByPMID(String id)
  {
    OutcomeTable.Row row = null;
    try
    {
      row = OutcomeTable.getRow("pmid", id);
      
      //turn the result into a string
      if(row != null)
        result = "PMID: " + row.getPmid() + 
                      "\nOutcome: " + row.getOutcome() + 
                      "\nOther_outcome: " + row.getOther_outcome() + 
                      "\nUMLS_category: " + row.getUmls_category() + 
                      "\nUMLS_group: " + row.getUmls_group() + 
                      "\nYear: " + row.getYear() + "\n";
      else
        result = "No outcome entry found for PMID " + id;
      
    } catch (SQLException e)
    {
      
      e.printStackTrace();
    }
    
    return result;   
  }

  @Override
  public String getPopulationByPMID(String id)
  {
    PopulationTable.Row row = null;
    try
    {
      row = PopulationTable.getRow("pmid", id);
      
      //turn the result into a string
      if(row != null)
        result = "PMID: " + row.getPmid() + 
                      "\nPopulation: " + row.getPopulation() + 
                      "\nOther_population: " + row.getOther_population() + 
                      "\nEthnicity: " + row.getEthnicity() + 
                      "\nGender: " + row.getGender() + 
                      "\nNationality: " + row.getNationality() +
                      "\nYear: " + row.getYear() + "\n";
      else
        result = "No population entry found for PMID " + id;
      
    } catch (SQLException e)
    {
      
      e.printStackTrace();
    }
    
    return result;
  }

  @Override
  public String getStudyDesignByPMID(String id)
  {
    Study_designTable.Row row = null;
    try
    {
      row = Study_designTable.getRow("pmid", id);
      
      //turn the result into a string
      if(row != null)
        result = "PMID: " + row.getPmid() + 
                      "\nArm: " + row.getArm() + 
                      "\nBlinded: " + row.getBlinded() + 
                      "\nCase_control_type: " + row.getCase_control_type() + 
                      "\nClinical: " + row.getClinical() + 
                      "\nCohort_type: " + row.getCohort_type() +
                      "\nIs_it_serial: " + row.getIs_it_serial() +
                      "\nOccupational: " + row.getOccupational() +
                      "\nOthers_study_design: " + row.getOthers_study_design() +
                      "\nPhase: " + row.getPhase() +
                      "\nQuasi_experimental_type: " + row.getQuasi_experimental_type() +
                      "\nSponsored: " + row.getSponsored() +
                      "\nSynthesis_of_Evidence: " + row.getSynthesis_of_evidence() +
                      "\ntime_attribute: " + row.getTime_attribute() +
                      "\nTreatment_response: " + row.getTreatment_response() +
                      "\nType_of_randomisation: " + row.getType_of_randomization() +
                      "\ntype_of_review: " + row.getType_of_review() +
                      "\ntype_of_study: " + row.getType_of_study() +
                      "\nYear: " + row.getYear() + "\n";
      else
        result = "No study design entry found for PMID " + id;
      
    } catch (SQLException e)
    {
      
      e.printStackTrace();
    }
    
    return result;
  }

  //assemble and run query for a static search, extract and return results
  @Override
  public List<StaticEpiQueryResult> runStaticQuery(StaticEpiQuery query)
  {
    // TODO Auto-generated method stub
    return null;
  }
  

}
