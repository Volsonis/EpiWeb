package epiweb.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import epiweb.client.model.StaticEpiQuery;

public class AdvancedSearchView extends Composite
{
  private VerticalPanel vPanel = new VerticalPanel();
  
  MainView main;
  
  //FlexTable
  private FlexTable flexTable;
  
  //Buttons
  private Button addRowBtn;
  private Button removeRowBtn;
  private Button searchBtn;
  
  //Static Lists
  private static final String[] dimensions = {"Covariate", "Effect Size", "Exposure", "Outcome", "Population", "Study Design"};
  private static final String[] operators = {"AND", "OR", "NOT"};
  
  public AdvancedSearchView(MainView main)
  {
    initWidget(this.vPanel);
    
    this.main = main;
    
    //add a flextable
    flexTable = new FlexTable();
    FlexCellFormatter cellFormatter = flexTable.getFlexCellFormatter(); //cellformatter to alter padding etc.
    flexTable.setWidth("600px");
    flexTable.addStyleName("cw-FlexTable"); //enables CSS entry
    flexTable.setCellSpacing(2);
    flexTable.setCellPadding(1);
    
    //initial field
    Label filler = new Label(" ");
    ListBox dropBox = new ListBox(false);
    for (int i = 0; i < dimensions.length; i++) 
      dropBox.addItem(dimensions[i]);
    TextBox tb = new TextBox();
    flexTable.setWidget(0, 1, dropBox);
    flexTable.setWidget(0, 2, tb);
    cellFormatter.setWidth(0, 0, "70px");
    
    
    
    //init buttons
    addRowBtn = new Button("Add Row");
    addRowBtn.addClickHandler(new AddRowBtnClickHandler());
    removeRowBtn = new Button("Remove Row");
    removeRowBtn.addClickHandler(new RemoveRowBtnClickHandler());
    searchBtn = new Button("Search");
    searchBtn.addClickHandler(new SearchBtnClickHandler());
    
    //add/remove buttons
    VerticalPanel buttonPanel = new VerticalPanel();
    buttonPanel.add(addRowBtn);
    buttonPanel.add(removeRowBtn);
    buttonPanel.setStyleName("cw-FlexTable-buttonPanel");
    //buttonPanel.add(searchBtn);
    flexTable.setWidget(0, 3, buttonPanel);
    cellFormatter.setVerticalAlignment(0, 3, HasVerticalAlignment.ALIGN_TOP);
    
    //searchbutton
    VerticalPanel searchBtnPanel = new VerticalPanel();
    searchBtnPanel.add(searchBtn);
    
    //add 2 rows init
    addRow();
    addRow();
    
    vPanel.add(flexTable);
    this.vPanel.add(searchBtnPanel);
    
  }
  
  
  
  
  
  //ClickHandlers
  private class AddRowBtnClickHandler implements ClickHandler
  {

    @Override
    public void onClick(ClickEvent event)
    {
      addRow();
    }
    
  }
  
  private class RemoveRowBtnClickHandler implements ClickHandler
  {

    @Override
    public void onClick(ClickEvent event)
    {
      removeRow();      
    }
    
  }
  
  private class SearchBtnClickHandler implements ClickHandler
  {

    @Override
    public void onClick(ClickEvent event)
    {
      //compile the query from the fields
      
      //send the query
      //TODO implement dynamic queries
    }
    
  }
  
  
  //Add a row to the flex table.
  private void addRow() {
    
    //construct Panel
    ListBox opBox = new ListBox(false);
    for (int i = 0; i < operators.length; i++) 
      opBox.addItem(operators[i]);
    ListBox dimBox = new ListBox(false);
    for (int i = 0; i < dimensions.length; i++) 
      dimBox.addItem(dimensions[i]);
    Label separator = new Label(" : ");
    TextBox tb = new TextBox();
    
    //add Panel
    int numRows = flexTable.getRowCount();
    flexTable.setWidget(numRows, 0, opBox);
    flexTable.setWidget(numRows, 1, dimBox);
    flexTable.setWidget(numRows, 2, tb);
    //flexTable.getFlexCellFormatter().setRowSpan(0, 1, numRows + 1);
  } //private void addRow
  
  //remove a row from the FlexTable
  private void removeRow() {
    int numRows = flexTable.getRowCount();
    if (numRows > 1) {
      flexTable.removeRow(numRows - 1);
      //flexTable.getFlexCellFormatter().setRowSpan(0, 1, numRows - 1);
    }
  } //private void removeRow
}
