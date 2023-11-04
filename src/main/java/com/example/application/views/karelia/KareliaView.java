package com.example.application.views.karelia;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.ListStyleType;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;

@PageTitle("Karelia")
@Route(value = "Karelia", layout = MainLayout.class)
public class KareliaView extends Main implements HasComponents, HasStyle {

    private OrderedList imageContainer;

    public KareliaView() {
        constructUI();

        imageContainer.add(new KareliaViewCard("Кижи",
                "https://traveltimes.ru/wp-content/uploads/2021/09/kizhi5.jpg"));
        imageContainer.add(new KareliaViewCard("Кивач",
                "https://avatars.dzeninfra.ru/get-zen_doc/1718877/pub_64da9ece4e2a872cc4416bb8_64daaf934e2a872cc44f5bf7/scale_1200"));
        imageContainer.add(new KareliaViewCard("Рускеала",
                "https://ruskeala.ru/d/ayu_82021600xtiny.jpg"));
        imageContainer.add(new KareliaViewCard("Воттоваара",
                "https://sportishka.com/uploads/posts/2022-11/1667474446_22-sportishka-com-p-vottovaara-gora-pinterest-25.jpg"));
        imageContainer.add(new KareliaViewCard("Ладожские шхеры",
                "https://static.guidego.ru/625fe04b31b8e8d905c054a5.1600x1200.jpeg"));
        imageContainer.add(new KareliaViewCard("Марциальные воды",
                "https://europeanmuseumforum.ru/wp-content/uploads/a/1/8/a18a087c6afd5a064010628db11049e2.jpeg"));

    }

    private void constructUI() {
        addClassNames("karelia-view");
        addClassNames(MaxWidth.SCREEN_LARGE, Margin.Horizontal.AUTO, Padding.Bottom.LARGE, Padding.Horizontal.LARGE);

        HorizontalLayout container = new HorizontalLayout();
        container.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

        VerticalLayout headerContainer = new VerticalLayout();
        H2 header = new H2("Карелия");
        header.addClassNames(Margin.Bottom.NONE, Margin.Top.XLARGE, FontSize.XXXLARGE);
         Paragraph description = new Paragraph();
        description.addClassNames(Margin.Bottom.XLARGE, Margin.Top.NONE, TextColor.SECONDARY);
        headerContainer.add(header, description);

        Select<String> sortBy = new Select<>();
        sortBy.setLabel("Sort by");
        sortBy.setItems("Popularity", "Newest first", "Oldest first");
        sortBy.setValue("Popularity");

        imageContainer = new OrderedList();
        imageContainer.addClassNames(Gap.MEDIUM, Display.GRID, ListStyleType.NONE, Margin.NONE, Padding.NONE);

        container.add(headerContainer, sortBy);
        add(container, imageContainer);

    }
}
