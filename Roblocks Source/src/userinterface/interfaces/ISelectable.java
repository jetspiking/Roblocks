package userinterface.interfaces;

import userinterface.enums.SelectionType;

public interface ISelectable {
    void select();
    void deselect();
    SelectionType getType();
}
