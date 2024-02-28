# Week 15, Day 3 Notes

Today we are talking about **Responsive Web Design**. 

Resources:
- [MDN Responsive Design](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Responsive_Design)
- [CSS Tricks Floats](https://css-tricks.com/all-about-floats/)
- [CSS Tricks Flexbox Guide](https://css-tricks.com/snippets/css/a-guide-to-flexbox/#aa-flexbox-properties)
- [CSS Tricks Grid Guide](https://css-tricks.com/snippets/css/complete-guide-grid/#aa-display)

## Legacy Methods for Creating Layouts

To create a layout such as below, people used to use tables, rows, and cells. Then came floats, positioning and inline-block. These layout hacks left out important functionality like vertical centering. Nowadays, we have **Flex-box** and **CSS Grid**.

![Website Layout Idea](./imgs/Magento-2-Layout-Overview-3.png)

### Float Positioning

Floated elements remain a part of the flow of the web page. Compared to absolute positioned elements that are removed from the flow of the document.

![Floating Images in Text](./imgs/float-images.png)

```css
aside {
    float: right;
}
```

If you want an item next to the float to move below the float, use the `clear` property.

```css
footer {
    clear: both;
}
```