package mi.mi.miklash.slidingpuzzle.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node extends ImageView {

    private int nodeNumber;
    private boolean isSelected;

    public Node(Image image, int nodeNumber) {
        super(image);
        this.nodeNumber = nodeNumber;

        initNode();
    }

    private void initNode() {
        this.setFitWidth(100);
        this.setFitHeight(100);
    }

    public boolean isSelected() {
        return isSelected;
    }


    public void setSelected() {
        isSelected = true;

    }

    public void setNotSelected() { //show sleeve
        isSelected = false;
    }


    public void swapNodes(Node secondSelected) {

        Image temp = this.getImage();
        this.setImage(secondSelected.getImage());
        secondSelected.setImage(temp);

//        int tempNumber = this.getNodeNumber();
//        this.setNodeNumber(secondSelected.getNodeNumber());
//        secondSelected.setNodeNumber(tempNumber);

        System.out.println("swap possible");


    }



}

