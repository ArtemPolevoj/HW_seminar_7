package com.example.application.views.calculator;

import com.example.application.services.Calculator;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Calculator")
@Route(value = "Calculator", layout = MainLayout.class)
@Uses(Icon.class)
public class CalculatorView extends Composite<VerticalLayout> {

    public CalculatorView(Calculator calculator) {
        TextField first = new TextField("Первое значение");
        Select<String> select = new Select<>();
        TextField second = new TextField("Второе значение");
        Button buttonPrimary = new Button("Рассчитать");
        TextField result = new TextField("Результат");
        result.addClassName("visual-view-builder-view-text-field-1");
        select.setItems("+", "-", "/", "*", "%");
        select.setLabel("Операция");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().add(first);
        getContent().add(select);
        getContent().add(second);
        getContent().add(buttonPrimary);
        getContent().add(result);
        first.addKeyPressListener(Key.ENTER, e -> select.focus());
        select.addValueChangeListener(e -> second.focus());
        second.addKeyPressListener(Key.ENTER, e -> buttonPrimary.focus());
        buttonPrimary.addClickListener(e -> result.setValue(calculator.calculate(first.getValue(),
                second.getValue(),
                select.getValue())));
    }
}
