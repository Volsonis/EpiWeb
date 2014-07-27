package epiweb.client;

import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;

import epiweb.client.model.StaticEpiQueryResult;

public class ResultTable extends Composite
{
  
  //rootPanel
  private VerticalPanel tablePanel = new VerticalPanel();
  
  private List<StaticEpiQueryResult> resultData;
  
  //results as a CellTable
  private CellTable<StaticEpiQueryResult> cellTable;
  
  
  
  //constructor
  public ResultTable(final List<StaticEpiQueryResult> resultData)
  {
    initWidget(this.cellTable);
    
    this.resultData = resultData;
    
    cellTable = new CellTable<StaticEpiQueryResult>();
    //rows per page
    cellTable.setPageSize(25);
    
    
    //Add columns:
    //pmid
    TextColumn <StaticEpiQueryResult> pmidCol = new TextColumn<StaticEpiQueryResult>() {
      @Override
      public String getValue(StaticEpiQueryResult object) {
        return object.getPmid();
      }
    };
    this.cellTable.addColumn(pmidCol, "PMID");
    
    //year
    TextColumn <StaticEpiQueryResult> yearCol = new TextColumn<StaticEpiQueryResult>() {
      @Override
      public String getValue(StaticEpiQueryResult object) {
        return object.getYear();
      }
    };
    this.cellTable.addColumn(yearCol, "Year");
    
    //title
    TextColumn <StaticEpiQueryResult> titleCol = new TextColumn<StaticEpiQueryResult>() {
      @Override
      public String getValue(StaticEpiQueryResult object) {
        return object.getTitle();
      }
    };
    this.cellTable.addColumn(titleCol, "Title");    
        
    
    
    //associate an asyncDataProvider with the table so that the data in it can be pulled from the server
    AsyncDataProvider<StaticEpiQueryResult> provider = new AsyncDataProvider<StaticEpiQueryResult>() {

      @Override
      protected void onRangeChanged(HasData<StaticEpiQueryResult> display)
      {
        // TODO Auto-generated method stub
        int start = display.getVisibleRange().getStart();
        int end = start + display.getVisibleRange().getLength();
        end = end >= resultData.size() ? resultData.size() : end;
        List<StaticEpiQueryResult> sub = resultData.subList(start, end);
        updateRowData(start, sub);
      }
      
    };
    provider.addDataDisplay(cellTable);
    provider.updateRowCount(resultData.size(), true);

    SimplePager pager = new SimplePager();
    pager.setDisplay(cellTable);

    //add table and pager to the panel
    this.tablePanel.add(cellTable);
    this.tablePanel.add(pager);


  }
}
