//package model;
//
//
//import javafx.geometry.Pos;
//import javafx.scene.chart.LineChart;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.XYChart;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//
//public class Graph {
//    private BorderPane borderPane;
//
//    public Graph(BorderPane bp) {
//        borderPane = bp;
//    }
//
//        //TODO: Put graph into seperate class
//        //TODO: Figure out some styling/CSS for graph
//        //TODO: Connect real data/stats to graph
//
//        GridPane centerGridPane = new GridPane();
//        centerGridPane.setAlignment(Pos.CENTER);
//        borderPane.setCenter(centerGridPane);
//
//
//        //Defining the x axis
//        NumberAxis theXAxis = new NumberAxis(0, 10, 1);
//        theXAxis.setLabel("Days");
//        // theXAxis.setStyle("-fx-background-color: #86D0F7");
//
//
//
//        //Defining the y axis
//        NumberAxis theYAxis = new NumberAxis(0, 30,  1);
//        theYAxis.setLabel("No.of Cat Photos");
//        theYAxis.setStyle("-fx-background-color: #86D0F7");
//
//        //Creating the line chart
//        LineChart linechart = new LineChart(theXAxis, theYAxis);
//
//
//        //Prepare XYChart.Series objects by setting data
//        XYChart.Series series = new XYChart.Series();
//        series.setName("Cat Photos Collected");
//
//        //Test Data -> Connect Somehow with real stats
//        series.getData().add(new XYChart.Data(0, 0));
//        series.getData().add(new XYChart.Data(1, 1));
//        series.getData().add(new XYChart.Data(2, 4));
//        series.getData().add(new XYChart.Data(3, 10));
//        series.getData().add(new XYChart.Data(4, 5));
//        series.getData().add(new XYChart.Data(5, 20));
//
////        Node line = series.getNode().lookup(".chart-series-line");
////        line.setStyle("-fx-fill: #FF0000");
//
//        //Setting the data to Line chart
//        linechart.getData().add(series);
//
//        centerGridPane.getChildren().add(linechart);
//}
