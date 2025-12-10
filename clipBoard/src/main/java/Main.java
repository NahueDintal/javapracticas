import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      // Configurar Look and Feel para mejor apariencia
      try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception e) {
      }

      JFrame frame = new JFrame();
      frame.setUndecorated(true); // Sin bordes
      frame.setBackground(new Color(0, 0, 0, 100)); // Fondo semitransparente

      // Hacer la ventana redondeada (opcional)
      // frame.setShape(new RoundRectangle2D.Double(0, 0, 500, 300, 30, 30));

      // Panel principal con transparencia
      JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          // Fondo con blur personalizado
          Graphics2D g2d = (Graphics2D) g.create();
          g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
          g2d.setColor(new Color(20, 20, 30, 180));
          g2d.fillRect(0, 0, getWidth(), getHeight());
          g2d.dispose();
        }
      };
      panel.setLayout(new BorderLayout());
      panel.setOpaque(false);

      // Contenido de ejemplo
      JLabel label = new JLabel("Ventana Transparente", SwingConstants.CENTER);
      label.setFont(new Font("Arial", Font.BOLD, 24));
      label.setForeground(Color.WHITE);

      // Botón de ejemplo
      // JButton button = new JButton("Cerrar");
      // button.addActionListener(e -> System.exit(0));

      // panel.add(label, BorderLayout.CENTER);
      // panel.add(button, BorderLayout.SOUTH);
      //
      // frame.setContentPane(panel);
      // frame.setSize(500, 300);
      // frame.setLocationRelativeTo(null);
      // frame.setVisible(true);

      // Drag para mover ventana
      Point point = new Point();
      panel.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent e) {
          point.x = e.getX();
          point.y = e.getY();
        }
      });
      panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        public void mouseDragged(java.awt.event.MouseEvent e) {
          Point p = frame.getLocation();
          frame.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
        }
      });
    });
  }
}
