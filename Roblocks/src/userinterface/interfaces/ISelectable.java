package userinterface.interfaces;

import userinterface.enums.SelectionType;

/**
 * Interface for selectable Views, Fragments or Windows.
 */

public interface ISelectable {
    void select();
    void deselect();
    SelectionType getType();
}
