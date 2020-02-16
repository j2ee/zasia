package org.j2ee.zasia.ui;

//import sun.net.www.http.HttpClient;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.util.Vector;

public class ZasiaFrame extends JFrame {

    private String userProfileDir = System.getenv("USERPROFILE") + File.separator + ".zasia";

    // 菜单
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem newMenuItem = new JMenuItem("New");
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    JMenu helpMenu = new JMenu("Help");
    JMenuItem aboutMenuItem = new JMenuItem("About");

    // 工具栏
//    JToolBar toolBar = new JToolBar();
//    JMenuItem newBtn = new JMenuItem("New");
//    JMenuItem exitBtn = new JMenuItem("Exit");
//    JMenuItem aboutBtn = new JMenuItem("About");

    Action exitAction = new AbstractAction("Exit"/*, new ImageIcon(getClass().getResource("/icons/exit.png"))*/) {

        private static final long serialVersionUID = 1L;

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    };

    Action helpAction = new AbstractAction("Help"/*, new ImageIcon(getClass().getResource("/icons/help.gif"))*/) {

        private static final long serialVersionUID = 1L;

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "lovol version: " + "version", "about", JOptionPane.PLAIN_MESSAGE);
        }

    };

    JPanel eastPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel northPanel = new JPanel();

    // 主面板
    JPanel centerPanel = new JPanel();
    JTextField downloadUrl = new JTextField(100);
    JTextField savePath = new JTextField(100);
    //    JTextField username = new JTextField(20);
//    JPasswordField password = new JPasswordField(20);
//    JComboBox<String> system = new JComboBox<>(systems);
    // JTextField page = new JTextField(3);
//    JTextField from = new JTextField(10);
//    JTextField to = new JTextField(10);
//    JTextField path = new JTextField(60);
//    JButton open = new JButton("打开");
    JButton browserBtn = new JButton("Browser ");
    JButton downloadBtn = new JButton("Download");
    JFileChooser fileChooser = new JFileChooser();
    //    JButton run = new JButton("Run");
//    JButton export = new JButton("导出");
    //    JButton stop = new JButton("Stop");
//    JButton show = new JButton("Show");
//    JTextField searchStr = new JTextField(20);
//    JButton search = new JButton("搜索");
//    JButton query = new JButton("查询");
//    JButton prev = new JButton("上一页");
//    JButton next = new JButton("下一页");
//    JButton all = new JButton("全选");
//    JButton refresh = new JButton("刷新");
    // JTextField page = new JTextField(3);
    // 总共有19页
//    JComboBox<String> page = new JComboBox<String>(pages);
    JTable taskTable = new JTable(new ZasiaTableModel());
//    JTable table = new JTable(rowData, columnNames);

    // 详情
//    JTextArea detail = new JTextArea(5, 20);
//    JScrollPane scroll = new JScrollPane(detail);

    public ZasiaFrame() {

        super("Zasia");

        // 菜单
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        fileMenu.setMnemonic('F');
        fileMenu.add(newMenuItem);
        fileMenu.addSeparator();
//        file.add(exit);
        fileMenu.add(exitAction);
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        helpMenu.setMnemonic('H');
        helpMenu.add(aboutMenuItem);
//        about.setIcon(new ImageIcon(getClass().getResource("/icons/help.gif")));
        aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        setJMenuBar(menuBar);

        // 工具栏
//        toolBar.setForeground(new Color(1,1,1));
//        toolBar.add(exitAction).setToolTipText("exit");
//        toolBar.add(helpAction).setToolTipText("help");
//        add(toolBar, BorderLayout.NORTH);
//        toolBar.setFloatable(false);

        // 主面板
        Box vbox = Box.createVerticalBox();
        Box hbox = Box.createHorizontalBox();
//        hbox.add(new JLabel("URL"));
//        hbox.add(downloadUrl);
        // downloadUrl.setText("http://www.tjhexi.gov.cn/Pages/index.aspx");
        // downloadUrl.setText("http://mail.tjhexi.gov.cn/");
//        downloadUrl.setText("http://zw.tjhexi.gov.cn/zmhd/login/check.asp");
//        vbox.add(hbox);
//        hbox = Box.createHorizontalBox();
//        hbox.add(new JLabel("账号"));
//        hbox.add(username);
//        username.setText("zr");
//        vbox.add(hbox);
//        hbox.add(new JLabel("密码"));
//        hbox.add(password);
//        password.setText("888888");
//        password.setEchoChar('*');
//        hbox.add(new JLabel("系统"));
//        hbox.add(system);
//        system.setSelectedIndex(1);
        // hbox.add(new JLabel("Page"));
        // hbox.add(page);
        // page.setText("1");
//        hbox.add(new JLabel("From"));
//        hbox.add(from);
//        vbox.add(hbox);
//        hbox.add(new JLabel("To"));
//        hbox.add(to);
//        vbox.add(hbox);
        hbox = Box.createHorizontalBox();
        hbox.add(new JLabel(" Save to Path "));
        savePath.setText(System.getenv("TMP") + File.separator + "zasia");
        hbox.add(savePath);
        hbox.add(browserBtn);
        vbox.add(hbox);
        hbox = Box.createHorizontalBox();
        hbox.add(new JLabel(" Download URL "));
        downloadUrl.setText("");
        hbox.add(downloadUrl);
        hbox.add(downloadBtn);
        vbox.add(hbox);
//        hbox.add(path);
//        hbox.add(open);
//        vbox.add(hbox);
//        hbox = Box.createHorizontalBox();
//        hbox.add(all);
//        hbox.add(refresh);
//        hbox.add(run);
//        hbox.add(export);
//        hbox.add(stop);
//        hbox.add(show);
//        hbox.add(searchStr);
//        hbox.add(search);
//        hbox.add(query);
//        hbox.add(prev);
//        hbox.add(page);
//        page.setPreferredSize(new Dimension(10, 10));
//        hbox.add(next);
//        hbox.add(Box.createHorizontalStrut(400));
//        vbox.add(hbox);
        hbox = Box.createHorizontalBox();
        taskTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        taskTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        taskTable.getColumnModel().getColumn(2).setPreferredWidth(200);
//        taskTable.getColumnModel().getColumn(3).setPreferredWidth(40);
//        taskTable.getColumnModel().getColumn(4).setPreferredWidth(50);
//        ((DefaultTableCellRenderer)taskTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
//        table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
//        table.setEnabled(false);
        hbox.add(new JScrollPane(taskTable));
        vbox.add(hbox);
        centerPanel.add(vbox);

        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

//        left.add("downloading", new JLabel("Downloading"));
//        add(left, BorderLayout.WEST);

        add(centerPanel);

        // 详情
//        detail.setLineWrap(true);
//        detail.setWrapStyleWord(true);
//        scroll.setAutoscrolls(true);
//        scroll.setBounds(0, 0, 199, 199);
//        add(scroll, BorderLayout.SOUTH);
//        add(new JScrollPane(table), BorderLayout.SOUTH);

        // 监听
        exitMenuItem.addActionListener(e -> System.exit(0));

        aboutMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(null, "Zasia version: 1.0", "About", JOptionPane.PLAIN_MESSAGE));

        browserBtn.addActionListener(e -> {
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                savePath.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
            // fileChooser.setVisible(true);
        });

        downloadBtn.addActionListener(e -> {
            String pathss = savePath.getText().trim();
            if (pathss.isEmpty()) {
                savePath.setText(System.getenv("TMP") + File.separator + "zasia");
            }
            String urls = downloadUrl.getText().trim();
            downloadUrl.setText(urls);
            if (urls.isEmpty()) {
                return;
            }
            String filename = System.currentTimeMillis() + "";
            try {
                URL url = new URL(downloadUrl.getText());
                String protocol = url.getProtocol();
                if (protocol == null) {
                    return;
                }
                String path = url.getPath();
                String[] paths = path.split("/");
                String name = paths[paths.length - 1];
                if (name.length() > 0) {
                    filename = name;
                }
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5000);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9*");
                conn.setRequestProperty("Accept-Language", "en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7");
//                conn.setRequestProperty("Charset", "UTF-8");
                conn.setRequestProperty("Connection", "keep-alive");
                int fileSize = conn.getContentLength();
                System.out.println("file size: " + fileSize);
                File sp = new File(savePath.getText());
                if (!sp.exists()) {
                    sp.mkdirs();
                }
                RandomAccessFile file = new RandomAccessFile(savePath.getText() + File.separator + filename, "rw");
                file.setLength(fileSize);
                file.close();
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                URL url = new URL(downloadUrl.getText());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5000);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9*");
                conn.setRequestProperty("Accept-Language", "en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7");
//                conn.setRequestProperty("Charset", "UTF-8");
                conn.setRequestProperty("Connection", "keep-alive");
                int fileSize = conn.getContentLength();
                System.out.println("file size: " + fileSize);
//                String filename = System.currentTimeMillis() + "";
                File sp = new File(savePath.getText());
                if (!sp.exists()) {
                    sp.mkdirs();
                }
                RandomAccessFile file = new RandomAccessFile(savePath.getText() + File.separator + filename, "rw");
                InputStream inputStream = conn.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(buffer)) != -1) {
                    file.write(buffer, 0, len);
                }
                inputStream.close();
                file.close();
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "URL Error!", "Error", JOptionPane.PLAIN_MESSAGE);
                return;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
//            HttpClient httpClient = HttpClient.newBuilder().build();
            ZasiaTableModel taskTableModel = (ZasiaTableModel) taskTable.getModel();
            Vector<Object> row = new Vector<>();
            row.add(filename);
            row.add(downloadUrl.getText());
            row.add(savePath.getText());
//            row.add("status");
//            row.add("start");
            taskTableModel.getRowData().add(row);
            SwingUtilities.updateComponentTreeUI(taskTable);
        });

//        all.addActionListener(e -> {
//            checkAll = !checkAll;
//            for (Vector<Object> v : rowData) {
//                v.set(0, checkAll);
//            }
//            SwingUtilities.updateComponentTreeUI(this);
//        });

//        table.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
////                int row = table.getSelectedRow();
////                int column = table.getSelectedColumn();
////                if (table.isCellSelected(row, column)) {
////                    if (column == 8) {
////                        Vector<Object> data = rowData.get(row);
//////                        String href = (String) data.get(column);
//////                        JButton s = new JButton("ssss");
//////                        Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
//////                        Vector<Object> row1 = null;
//////                        Vector<Object> cols = new Vector<Object>();
//////                        cols.add("项目");
//////                        cols.add("值");
//////
//////                        row1 = new Vector<Object>();
//////                        row1.add("联系人");
//////                        row1.add("联系人");
//////                        rows.add(row1);
//////                         JTable t = new JTable(rows,cols);
//////                         t.getTableHeader().setVisible(false);
//////                         JScrollPane scrollPane = new JScrollPane(t);
////                        JOptionPane.showMessageDialog(null, new JScrollPane(queryDetail(data)), "详情", JOptionPane.PLAIN_MESSAGE);
////                    }
////
////                }
//                super.mouseClicked(e);
//            }
//
//        });

//        export.addActionListener(e -> {
//            detail.setText("导出开始 ...\n");
//            detail.paintImmediately(detail.getBounds());
//            SwingUtilities.updateComponentTreeUI(detail);
//            SwingUtilities.updateComponentTreeUI(scroll);
//            rowData.forEach((data) -> {
//                boolean check = (boolean) data.get(0);
//                if (check) {
//                    String no = (String) data.get(2);
//                    String title = ((String) data.get(3)).replaceAll("�h", "玥");
//                    String date = (String) data.get(6);
//                    Pattern pt = Pattern.compile("^\\d{4}-(\\d{1,2})-(\\d{1,2}).*");
//                    Matcher matcher = pt.matcher(date);
//                    if (matcher.find()) {
//                        String s0 = matcher.group(1);
//                        String s1 = matcher.group(2);
//                        date = s0 + "." + s1;
//                    }
//                    String href = (String) data.lastElement();
////                    System.out.println(href);
//
//                    stopFlag = false;
////                    Website website = new Website();
////                    website.setUrl(downloadUrl.getText());
////                    website.setPath(path.getText());
//
//                    try {
//                        Map<String, String> params = new HashMap<String, String>();
//                        params.put("domain", "tjhexi.gov.cn");
//                        params.put("userid", "zr");
//                        params.put("passwd", "888888");
//                        params.put("xt", "16");
//                        // params.put("page", page.getText());
////                        Response response = Jsoup.connect(website.getUrl()).data(params).method(Method.POST).execute();
////                        Map<String, String> cookies = response.cookies();
//
//                        // System.out.println(href + ":" + no + ":" + title);
//                        // System.out.println(page.getText());
////                        Document doc2 = Jsoup.connect("http://zw.tjhexi.gov.cn/zmhd/" + href).cookies(cookies).post();
//                        // System.out.println(doc2);
//                        // Pattern pattern = Pattern.compile("<tr>\\s+<td
//                        // width=\"25%\" height=\"25\"
//                        // align=\"center\">联系人</td>.*<td width=\"75%\"
//                        // height=\"25\"> 待处理 </td> \\s+</tr>");
////                        Elements elements2 = doc2.getElementsByAttributeValue("name", "form1");
//                        // System.out.println(elements2);
////                        Elements elements3 = elements2.get(0).getElementsByTag("tbody").get(0).getElementsByTag("tr");
//                        // System.out.println(elements3);
//                        String template = "templates/default-template.doc";
//                        InputStream is = null;
//                        OutputStream os = null;
//                        try {
//                            is = getClass().getClassLoader().getResourceAsStream(template);
////                            HWPFDocument doc = new HWPFDocument(is);
////                            Range range = doc.getRange();
////                            range.replaceText("${no}", no);
////                            range.replaceText("${date}", date);
////                            for (int j = 1; j < 10; j++) {
////                                Element element = elements3.get(j);
////                                String text = element.child(1).text().trim().replaceFirst("\\s+|　+", "");
////                                // System.out.println(text);
////                                text = text.replaceAll("�h", "玥").replaceAll("　+", "\r" + (char) 11 + "    ");
////                                range.replaceText("${" + docKeys[j] + "}", text);
////                            }
//                            String filename = no + title + date + ".doc";
////                            if (website.getPath() == null || "".equals(website.getPath().trim())) {
////                                website.setPath(".");
////                            }
////                            File savePath = new File(website.getPath());
//                            if (!savePath.exists()) {
//                                savePath.mkdirs();
//                            }
////                            os = new FileOutputStream(website.getPath() + File.separator + filename);
//                            detail.append(filename + "\n");
//                            // detail.invalidate();
//                            // detail.repaint();
//                            detail.paintImmediately(detail.getBounds());
//                            detail.paintImmediately(detail.getX(), detail.getY(), detail.getWidth(), detail.getHeight());
//                            detail.setCaretPosition( detail.getDocument().getLength());
//                            detail.setCaretPosition( detail.getText().length());
//                            // detail.setCaretPosition(detail.getDocument().getLength());
////                                    int height = 20;
////                                    Point p = new Point();
////                                    p.setLocation(0, detail.getLineCount() * height);
////                                    scroll.getViewport().setViewPosition(p);
//                            JScrollBar sbar = scroll.getVerticalScrollBar();
//                            sbar.setValue(sbar.getMaximum());
//                            SwingUtilities.updateComponentTreeUI(detail);
//                            SwingUtilities.updateComponentTreeUI(scroll);
//                            doc.write(os);
//                        } catch (FileNotFoundException ex) {
//                            ex.printStackTrace();
//                        } catch (IOException ex) {
//                            ex.printStackTrace();
//                        } finally {
////                            CloseUtils.close(is, os);
//                        }
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//            });
//            detail.append("导出结束");
//            JScrollBar sbar = scroll.getVerticalScrollBar();
//            sbar.setValue(sbar.getMaximum());
//            SwingUtilities.updateComponentTreeUI(detail);
//            SwingUtilities.updateComponentTreeUI(scroll);
//        });

//        page.addItemListener(e -> {
//            System.out.println(page.getSelectedItem());
//        });

//        query.addActionListener(e -> {
//            queryPage();
//        });

//        prev.addActionListener(e -> {
//            int pageNo = page.getSelectedIndex();
//            if (pageNo == 0) {
//                return;
//            } else {
//                pageNo--;
//                page.setSelectedIndex(pageNo);
//            }
//            queryPage();
//        });

//        next.addActionListener(e -> {
//            int pageNo = page.getSelectedIndex();
//            if (pageNo == page.getItemCount() - 1) {
//                return;
//            } else {
//                pageNo++;
//                page.setSelectedIndex(pageNo);
//            }
//            queryPage();
//        });

//        stop.addActionListener(e -> stopFlag = true);

//        setIconImage(new ImageIcon(getClass().getResource("/icons/lovol.png")).getImage());

        // 窗口设置
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
//            SwingUtilities.updateComponentTreeUI(table);
            ((DefaultTableCellRenderer) taskTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
//            table.getCellRenderer(row, column)
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
            tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
            taskTable.setDefaultRenderer(Object.class, tcr);//设置渲染器
            taskTable.setRowHeight(20);
            SwingUtilities.updateComponentTreeUI(fileChooser);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

//        setSize(1000, 600);
        setMinimumSize(new Dimension(800, 450));
        pack();
//        setPreferredSize(new Dimension(1800, 600));
        setResizable(false);
        // setLocationByPlatform(true);
        setLocationRelativeTo(this.getOwner());
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

}
