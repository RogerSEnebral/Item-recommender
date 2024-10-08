package FONTS.CapaDePresentacion.Vistas;

import FONTS.CapaDePresentacion.Controladores.CtrlHome;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;

public class VistaHome {
    private CtrlHome CH = new CtrlHome();
    private JFrame frame = new JFrame();
    private JPanel northPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private JPanel westPanel= new JPanel();
    private JPanel centerPanel = new JPanel();
    private JMenuBar barraMenu = new JMenuBar();
    private JMenu options = new JMenu("Options");
    private JMenuItem logOutMenuItem = new JMenuItem("Log Out");
    private JMenuItem editarPerfilMenuItem = new JMenuItem("Edit profile");
    private JMenuItem exportarMenuItem = new JMenuItem("Export");
    private JMenuItem selectColaborative = new JMenuItem("Select Collaborative");
    private JMenuItem selectKNN = new JMenuItem("Select KNN");
    private JMenuItem selectSuited = new JMenuItem("Select Suited");
    private JMenuItem selectTrending = new JMenuItem("Select Trending");
    private JMenuItem misItemsMenuItem = new JMenuItem("My rated items");
    private JMenuItem test = new JMenuItem("Test");
    private JButton homeButton = new JButton();
    private JFileChooser fileChooser = new JFileChooser();
    private JPanel homeButtonPanel = new JPanel();
    private JScrollPane scrollPane;
    private JButton item;
    private ArrayList<JButton> items_list = new ArrayList<JButton>();
    private JMenu selectRecomendationMenu = new JMenu("Select Recommendation");
    private miActionListener actionListener = new miActionListener();
    private miMouseListener mouseListener = new miMouseListener();
    private int sizecenterPanel = 0;


    public String str2html (String text){
        return "<html><center>" + text + "</center></html>";
    }

    public JButton display_Item(String[] datos) throws IOException {
        item = new JButton();
        String title = datos[0];
        Image image = null;
        URL url = null;
        boolean found = false;
        for(int i = 0; i < datos.length; ++i) {
            String[] atributo = datos[i].split(";;;");
            if(atributo[0].equals("img_url")) {
                url = new URL(atributo[2]);
                image = ImageIO.read(url);
                found = true;
            }
            else if(!found){
                url = new URL("https://aprende-a-programar.com/img/noImage.jpg");
                image = ImageIO.read(url);
            }
        }
        if(title != null) item.setText(str2html(title));
        if(image != null )item.setIcon(new ImageIcon(image));
        Border line = new LineBorder(Color.darkGray);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        item.setBorder(compound);
        item.setFocusable(false);
        item.setBackground(Color.darkGray);
        item.setForeground(new Color(0xE0E0E0));
        item.setHorizontalTextPosition(JLabel.CENTER);
        item.setVerticalTextPosition(JLabel.BOTTOM);
        item.setFont(new Font("Dubai", Font.PLAIN, 20));
        item.setPreferredSize(new Dimension(230,440));
        return item;
    }


    public void inicializar_Componentes() throws IOException {

        //-----------------Creo frame principal---------------------
        frame.setTitle("FilmFIB");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("./FONTS/CapaDePresentacion/assets/Logo.PNG");
        frame.setIconImage(icon.getImage());
        frame.setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
        frame.setMinimumSize(new Dimension(720,500));
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        //-----------------homeButton--------------------
        homeButton.setText("FilmFIB");
        homeButton.setFont(new Font("Dubai", Font.BOLD, 50));
        homeButton.setForeground(new Color(0xD47210));
        homeButton.setBackground(Color.darkGray);
        Border line = new LineBorder(Color.darkGray);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        homeButton.setBorder(compound);
        homeButton.setFocusable(false);
        homeButton.addActionListener(actionListener);
        homeButton.setAlignmentX(JButton.WEST);
        homeButton.setPreferredSize(new Dimension(200,50));
        homeButton.addMouseListener(mouseListener);

        //-----------------North panel---------------------
        northPanel.setBackground(Color.darkGray);
        northPanel.setPreferredSize(new Dimension(100,100));
        northPanel.setLayout(new BorderLayout());

        //-----------------homeButton panel---------------------
        homeButtonPanel .setBackground(Color.darkGray);
        homeButtonPanel.add(homeButton);

        //-----------------South panel---------------------
        southPanel.setBackground(Color.darkGray);
        southPanel.setPreferredSize(new Dimension(100,100));

        //-----------------eastPanel---------------------
        eastPanel.setBackground(Color.darkGray);
        eastPanel.setPreferredSize(new Dimension(100,100));

        //-----------------westPanel---------------------
        westPanel.setBackground(Color.darkGray);
        westPanel.setPreferredSize(new Dimension(100,100));

        //-----------------centerPanel---------------------
        centerPanel.setBackground(Color.darkGray);
        centerPanel.setLayout(new FlowLayout(FlowLayout.LEADING,25,20));
        Vector<String[]> recomendedItems = CH.getRecomendedItems();
        for (int i = 1; i < recomendedItems.size(); ++i) {
            String[] item_info = recomendedItems.elementAt(i);
            items_list.add(display_Item(item_info));
            items_list.get(i - 1).addActionListener(actionListener);
            items_list.get(i - 1).addMouseListener(mouseListener);
            centerPanel.add(items_list.get(i - 1));
        }

        //-----------------ScrollPane---------------------
        if(items_list.size() % 5 == 0) sizecenterPanel = (items_list.size() / 5) * 475;
        else sizecenterPanel = ((items_list.size() / 5) * 475) + 475;
        centerPanel.setPreferredSize(new Dimension(100,sizecenterPanel));
        scrollPane = new JScrollPane(centerPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBackground(Color.darkGray);
        line = new LineBorder(Color.darkGray);
        margin = new EmptyBorder(0, 0, 0, 0);
        compound = new CompoundBorder(line, margin);
        scrollPane.setBorder(compound);

        //----------------MenuSelection---------------------
        selectRecomendationMenu.setAlignmentX(JMenu.EAST);
        selectRecomendationMenu.setBackground(Color.darkGray);
        selectRecomendationMenu.setForeground(new Color(0xE0E0E0));
        selectRecomendationMenu.addMouseListener(mouseListener);

        selectColaborative.setBackground(Color.darkGray);
        selectColaborative.setForeground(new Color(0xE0E0E0));
        selectColaborative.addActionListener(actionListener);

        selectKNN.setBackground(Color.darkGray);
        selectKNN.setForeground(new Color(0xE0E0E0));
        selectKNN.addActionListener(actionListener);

        selectSuited.setBackground(Color.darkGray);
        selectSuited.setForeground(new Color(0xE0E0E0));
        selectSuited.addActionListener(actionListener);

        selectTrending.setBackground(Color.darkGray);
        selectTrending.setForeground(new Color(0xE0E0E0));
        selectTrending.addActionListener(actionListener);

        selectRecomendationMenu.add(selectTrending);
        selectRecomendationMenu.add(selectKNN);
        selectRecomendationMenu.add(selectColaborative);
        selectRecomendationMenu.add(selectSuited);

        //----------------MenuOptions---------------------
        barraMenu.setAlignmentX(JMenuBar.RIGHT_ALIGNMENT);
        barraMenu.setForeground(new Color(0xE0E0E0));
        barraMenu.add(options);
        barraMenu.add(selectRecomendationMenu);
        barraMenu.setBackground(Color.darkGray);

        options.setAlignmentX(JMenu.EAST);
        options.setBackground(Color.darkGray);
        options.setForeground(new Color(0xE0E0E0));
        options.addMouseListener(mouseListener);

        logOutMenuItem.addActionListener(actionListener);
        logOutMenuItem.setBackground(Color.darkGray);
        logOutMenuItem.setForeground(new Color(0xE0E0E0));

        editarPerfilMenuItem.setBackground(Color.darkGray);
        editarPerfilMenuItem.setForeground(new Color(0xE0E0E0));
        editarPerfilMenuItem.addActionListener(actionListener);

        exportarMenuItem.setBackground(Color.darkGray);
        exportarMenuItem.setForeground(new Color(0xE0E0E0));
        exportarMenuItem.addActionListener(actionListener);

        misItemsMenuItem.setBackground(Color.darkGray);
        misItemsMenuItem.setForeground(new Color(0xE0E0E0));
        misItemsMenuItem.addActionListener(actionListener);

        test.setBackground(Color.darkGray);
        test.setForeground(new Color(0xE0E0E0));
        test.addActionListener(actionListener);

        options.add(exportarMenuItem);
        options.add(editarPerfilMenuItem);
        options.add(misItemsMenuItem);
        options.add(test);
        options.add(logOutMenuItem);

        //----------------Añado itemos a los paneles---------------------
        northPanel.add(homeButtonPanel, BorderLayout.WEST);

        //----------------Ultimos ajustes al frame---------------------
        frame.setVisible(true);
        frame.setJMenuBar(barraMenu);
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    public VistaHome() throws IOException {
        inicializar_Componentes();
    }

    private class miActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == logOutMenuItem) {
                int res = JOptionPane.showConfirmDialog(null,"You're about to logout, do you want to export?","Logging out",JOptionPane.YES_NO_OPTION);
                if(res == 0) {
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int response = fileChooser.showSaveDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        String pathFolder = fileChooser.getSelectedFile().getAbsolutePath();
                        int result = CH.exportFiles(pathFolder);
                        if (result == 0) {
                            JOptionPane.showMessageDialog(null, "Your changes have been saved in the selected directory!", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else if (result == 1) {
                            JOptionPane.showMessageDialog(null, "Your items couldn't be saved!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        else if (result == 2) {
                            JOptionPane.showMessageDialog(null, "Files ratings.db.csv or  items.db.csv not found in this directory!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    frame.dispose();
                    VistaMenuInicial menuInicial = new VistaMenuInicial();
                }
                else if(res == 1) {
                    frame.dispose();
                    VistaMenuInicial menuInicial = new VistaMenuInicial();
                }
            }
            else if(e.getSource() == editarPerfilMenuItem) {
                frame.dispose();
                VistaEditarPerfil EditarPerfil = new VistaEditarPerfil();

            }
            else if(e.getSource() == selectColaborative) {
                boolean setted = CH.setRecommendationMode("Collaborative");
                if(!setted) {
                    JOptionPane.showMessageDialog(null, "The are no similar users for you!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    frame.dispose();
                    try {
                        VistaHome home = new VistaHome();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            else if (e.getSource() == selectKNN) {
                boolean setted = CH.setRecommendationMode("Knn");
                if(!setted) {
                    JOptionPane.showMessageDialog(null, "Rate an item with a 5 or more!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    frame.dispose();
                    try {
                        VistaHome home = new VistaHome();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            else if (e.getSource() == selectSuited) {
                CH.setRecommendationMode("Suited");
                frame.dispose();
                try {
                    VistaHome home = new VistaHome();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else if (e.getSource() == selectTrending) {
                boolean setted = CH.setRecommendationMode("Trending");
                if(!setted) {
                    JOptionPane.showMessageDialog(null, "Can't select trending items", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    frame.dispose();
                    try {
                        VistaHome home = new VistaHome();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            else if (e.getSource() == exportarMenuItem) {
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int response = fileChooser.showSaveDialog(null);
                if (response == JFileChooser.APPROVE_OPTION) {
                    String pathFolder = fileChooser.getSelectedFile().getAbsolutePath();
                    int res = CH.exportFiles(pathFolder);
                    if (res == 0) {
                        JOptionPane.showMessageDialog(null, "Your changes have been saved in the selected directory!", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
                    } else if (res == 1) {
                        JOptionPane.showMessageDialog(null, "Tus items o usuarios no se han podido guardar en la BD!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else if (res == 2) {
                        JOptionPane.showMessageDialog(null, "Los archivos ratings.db.csv o items.db.csv no existen en el directorio!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            else if(e.getSource() == misItemsMenuItem) {
                frame.dispose();
                try {
                    VistaMisItems myItems = new VistaMisItems();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else if (e.getSource() == homeButton) {
                frame.dispose();
                try {
                    VistaHome home = new VistaHome();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else if(e.getSource() == test) {
                boolean res = CH.setTest(true);
                if(res) {
                    frame.dispose();
                    try {
                        VistaTest vistaTest =  new VistaTest();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "This user can't test", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (!items_list.isEmpty()) {
                Vector<String[]> itemsBD = CH.getRecomendedItems();
                for (int i = 1; i < itemsBD.size(); ++i) {
                    if (e.getSource() == items_list.get(i - 1)) {
                        items_list.get(i - 1).setBackground(Color.gray);
                        items_list.get(i - 1).setCursor(new Cursor(Cursor.HAND_CURSOR));
                        String[] ITEM = itemsBD.elementAt(i);
                        frame.dispose();
                        try {
                            VistaPerfilItem perfilitem = new VistaPerfilItem(ITEM);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }

        }
    }

    private class miMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == homeButton) {
                homeButton.setBackground(Color.gray);
                frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            else if(!items_list.isEmpty()){
                for(int i = 0; i < items_list.size(); ++i) {
                    if(e.getSource() == items_list.get(i)) {
                        items_list.get(i).setBackground(Color.gray);
                        items_list.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == homeButton) {
                homeButton.setBackground(Color.darkGray);
                frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            else if(!items_list.isEmpty()){
                for(int i = 0; i < items_list.size(); ++i) {
                    if(e.getSource() == items_list.get(i)) {
                        items_list.get(i).setBackground(Color.darkGray);
                        items_list.get(i).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            }
        }
    }
}
