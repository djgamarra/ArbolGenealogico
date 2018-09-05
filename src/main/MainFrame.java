package main;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import data.Helper;
import data.Node;
import data.Parent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends javax.swing.JFrame {

    /**
     * Constructor de la vista de la interfaz gráfica, inicializa los
     * componentes de la vista, inicializa el indicador de selección y relación
     * y además escribe las instrucciones de uso del programa
     */
    public MainFrame() {
        initComponents();
        Helper.initIndicator();
        this.instructionsList.setText(""
                + "1. Creando un nuevo arbol: Sección roja. Escribe el nombre de tu primer pariente para crear un nuevo arbol, luego haz click en el boton \"Crear nuevo arbol\".\n"
                + "2. Agregando hijos a un pariente: Sección amarilla. Haz click en un pariente, se marcará en color verde, luego escribe el nombre del hijo a agregar y finalmente pulsa el botón de \"Agregar hijo\".\n"
                + "3. Eliminar un pariente y sus subsiguientes: Seccion amarilla. Haz click en un pariente, se marcará en color verde, luego pulsa el botón \"Eliminar pariente\".\n"
                + "4. Editar nombre de un pariente: Sección lila. Haz click en el pariente a editar, se marcará en color verde, luego escribe el nuevo nombre que deseas y pulsa el botón \"Cambiar nombre\".\n"
                + "5. Finalmente para conocer las relaciones entre un pariente y otro debes hacer click izquierdo en un pariente, se marcará de color verde, luego haz click derecho en cualquier otro pariente, se marcará en color lila, y en la sección lila del panel verá la relación o parentesco entre los dos parientes."
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        treeView = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        selectedName1 = new javax.swing.JLabel();
        childName = new javax.swing.JTextField();
        addChild = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        instructions = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        instructionsList = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        selectedName = new javax.swing.JLabel();
        newName = new javax.swing.JTextField();
        changeName = new javax.swing.JButton();
        relation = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        newTreeName = new javax.swing.JTextField();
        generate = new javax.swing.JButton();
        generate1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        treeView.setBackground(new java.awt.Color(255, 244, 193));
        treeView.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        treeView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeViewMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout treeViewLayout = new javax.swing.GroupLayout(treeView);
        treeView.setLayout(treeViewLayout);
        treeViewLayout.setHorizontalGroup(
            treeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        treeViewLayout.setVerticalGroup(
            treeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        selectedName1.setBackground(new java.awt.Color(235, 235, 194));
        selectedName1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        selectedName1.setForeground(new java.awt.Color(66, 66, 130));
        selectedName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectedName1.setText("Agregar hijo");
        selectedName1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        selectedName1.setOpaque(true);

        childName.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        childName.setForeground(new java.awt.Color(66, 66, 130));
        childName.setToolTipText("Child name");
        childName.setEnabled(false);
        childName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                childNameKeyReleased(evt);
            }
        });

        addChild.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        addChild.setForeground(new java.awt.Color(66, 130, 66));
        addChild.setText("Agregar hijo");
        addChild.setEnabled(false);
        addChild.setOpaque(false);
        addChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addChildActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        delete.setForeground(new java.awt.Color(190, 66, 6));
        delete.setText("Eliminar pariente");
        delete.setEnabled(false);
        delete.setOpaque(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(selectedName1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(childName))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addChild, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(childName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectedName1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addChild)
                    .addComponent(delete))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setForeground(new java.awt.Color(0, 255, 255));

        instructions.setBackground(new java.awt.Color(184, 235, 184));
        instructions.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        instructions.setForeground(new java.awt.Color(66, 66, 130));
        instructions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructions.setText("Instrucciones");
        instructions.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        instructions.setOpaque(true);

        instructionsList.setEditable(false);
        instructionsList.setBackground(new java.awt.Color(204, 255, 204));
        instructionsList.setColumns(20);
        instructionsList.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        instructionsList.setForeground(new java.awt.Color(66, 66, 130));
        instructionsList.setLineWrap(true);
        instructionsList.setRows(5);
        instructionsList.setWrapStyleWord(true);
        instructionsList.setBorder(null);
        jScrollPane2.setViewportView(instructionsList);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(instructions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instructions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        selectedName.setBackground(new java.awt.Color(184, 184, 235));
        selectedName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        selectedName.setForeground(new java.awt.Color(66, 66, 130));
        selectedName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectedName.setText("Seleccione un pariente");
        selectedName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        selectedName.setOpaque(true);

        newName.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        newName.setForeground(new java.awt.Color(66, 66, 130));
        newName.setToolTipText("Child name");
        newName.setEnabled(false);
        newName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newNameKeyReleased(evt);
            }
        });

        changeName.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        changeName.setForeground(new java.awt.Color(66, 66, 130));
        changeName.setText("Cambiar nombre");
        changeName.setEnabled(false);
        changeName.setOpaque(false);
        changeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeNameActionPerformed(evt);
            }
        });

        relation.setBackground(new java.awt.Color(184, 184, 235));
        relation.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        relation.setForeground(new java.awt.Color(66, 66, 130));
        relation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        relation.setText("...");
        relation.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectedName, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(newName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeName))
                    .addComponent(relation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectedName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(relation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeName)
                    .addComponent(newName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 153, 153));

        newTreeName.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        newTreeName.setForeground(new java.awt.Color(66, 66, 130));
        newTreeName.setToolTipText("Child name");
        newTreeName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newTreeNameKeyReleased(evt);
            }
        });

        generate.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        generate.setForeground(new java.awt.Color(66, 66, 130));
        generate.setText("Crear nuevo arbol");
        generate.setEnabled(false);
        generate.setOpaque(false);
        generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateActionPerformed(evt);
            }
        });

        generate1.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        generate1.setForeground(new java.awt.Color(66, 66, 130));
        generate1.setText("Prueba");
        generate1.setOpaque(false);
        generate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newTreeName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generate, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generate1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generate)
                    .addComponent(newTreeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generate1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(treeView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(treeView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Configura el panel de control dependiendo de si se ha seleccionado un
     * nodo X ó Y y establece valores iniciales para los campos de texto de
     * cambio de nombre entre otros y además obtiene la relación entre el nodo X
     * y Y si ambos han sido seleccionados y la muestra
     */
    private void updateOthers() {
        Node selectedNode = Helper.getSelectedNode();
        boolean selected = selectedNode != null;
        boolean secondary = Helper.getSecondaryNode() != null;
        boolean canAdd = selected && selectedNode.getLevel() <= 3 && !selectedNode.isBusy();
        this.childName.setText("");
        this.newName.setText("");
        this.newTreeName.setText("");
        this.childName.setEnabled(canAdd);
        this.generate.setEnabled(false);
        this.changeName.setEnabled(false);
        this.addChild.setEnabled(false);
        this.newName.setEnabled(selected);
        this.delete.setEnabled(selected && !Helper.selectedIsRoot());
        if (selected) {
            if (secondary) {
                this.selectedName.setText(
                        Helper.getSelectedNode().getParent().getShortName()
                        + " - "
                        + Helper.getSecondaryNode().getParent().getShortName()
                );
                this.relation.setText(Helper.calcRelationship());
            } else {
                this.relation.setText("...");
                this.selectedName.setText(Helper.getSelectedNode().getParent().getName());
            }
        } else {
            this.relation.setText("...");
            this.selectedName.setText("Seleccione un pariente");
        }
    }

    /**
     * Llama al método que establece las propiedades graficas de todos los nodos
     * y luego manda a dibujar
     *
     * @param type Tipo de dibujado que se hará
     */
    private void updateUI(int type) {
        Helper.setDrawingProps();
        Helper.drawTree(this.treeView.getGraphics(), type);
    }

    /**
     * Evento de click en el panel de dibujado del árbol, establece el nodo
     * selecionado ó secundario basándose en el punto en que se hizo click y
     * establece el nodo dependiendo del botón que ese presionó, luego manda a
     * dibujar todos los nodos
     *
     * @param evt Información del evento de click
     */
    private void treeViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeViewMouseClicked
        int node = evt.getButton() == java.awt.event.MouseEvent.BUTTON3 ? Helper.SECONDARY_NODE : Helper.SELECTED_NODE;
        Helper.onClick(evt.getX(), evt.getY(), node);
        Helper.drawTree(this.treeView.getGraphics(), Helper.NO_CLEAN);
        this.updateOthers();
    }//GEN-LAST:event_treeViewMouseClicked

    /**
     * Evento de click del botón de agregar hijo, manda a agregar el hijo al
     * nodo seleccionado (X) y redibuja el árbol
     *
     * @param evt Información del evento de click
     */
    private void addChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addChildActionPerformed
        Helper.addChild(new Parent(this.childName.getText().trim()), false);
        this.childName.setText("");
        this.addChild.setEnabled(false);
        this.updateUI(Helper.NO_CLEAN);
        this.updateOthers();
    }//GEN-LAST:event_addChildActionPerformed

    /**
     * Evento de click del botón de eliminar seleccionado, elimina el nodo,
     * actualiza el panel de control y actualiza la vista del árbol
     *
     * @param evt Información del evento de click
     */
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        Helper.removeSelected();
        this.updateOthers();
        this.updateUI(Helper.CLEAN_ALL);
    }//GEN-LAST:event_deleteActionPerformed

    /**
     * Evento de teclado del campo de texto de agregar hijo, habilita el botón
     * de agregar hijo en caso de que el campo no esté vacío
     *
     * @param evt Información del evento de teclado
     */
    private void childNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_childNameKeyReleased
        this.addChild.setEnabled(!this.childName.getText().trim().equals(""));
    }//GEN-LAST:event_childNameKeyReleased

    /**
     * Evento de teclado del campo de texto de cambiar de nombre, habilita el
     * botón de cambiar nombre en caso de que el campo no esté vacío
     *
     * @param evt Información del evento de teclado
     */
    private void newNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newNameKeyReleased
        this.changeName.setEnabled(!this.newName.getText().trim().equals(""));
    }//GEN-LAST:event_newNameKeyReleased

    /**
     * Evento de click del botón de cambio de nombre, cambia el nombre del nodo
     * seleccionado (X), actualiza el panel de control y actualiza la vista del
     * árbol
     *
     * @param evt Información del evento de click
     */
    private void changeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeNameActionPerformed
        Helper.getSelectedNode().setName(this.newName.getText().trim());
        this.updateOthers();
        this.updateUI(Helper.NO_CLEAN);
    }//GEN-LAST:event_changeNameActionPerformed

    /**
     * Evento de click del botón de crear nuevo árbol, crea el árbol, actualiza
     * el panel de control y actualiza la vista del árbol
     *
     * @param evt Información del evento de click
     */
    private void generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateActionPerformed
        Helper.addChild(new Parent(this.newTreeName.getText().trim()), true);
        this.updateOthers();
        this.updateUI(Helper.CLEAN_ALL);
    }//GEN-LAST:event_generateActionPerformed

    /**
     * Evento de teclado que habilita el botón de crear nuevo árbol si el campo
     * no está vacío
     *
     * @param evt Información del evento de teclado
     */
    private void newTreeNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newTreeNameKeyReleased
        this.generate.setEnabled(!this.newTreeName.getText().trim().equals(""));
    }//GEN-LAST:event_newTreeNameKeyReleased

    /**
     * Evento de click del botón de generar árbol de prueba, manda a generar el
     * árbol, actualiza el panel de control y actualiza la vista del árbol
     *
     * @param evt Información del evento de click
     */
    private void generate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate1ActionPerformed
        Helper.testTree();
        this.updateOthers();
        this.updateUI(Helper.NO_CLEAN);
    }//GEN-LAST:event_generate1ActionPerformed

    /**
     * Punto de partida del programa, establece el Look And Feel en
     * WindowsLookAndFeel, instancia un nuevo frame y lo muestra
     *
     * @param args
     */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new WindowsLookAndFeel());
            //</editor-fold>
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addChild;
    private javax.swing.JButton changeName;
    private javax.swing.JTextField childName;
    private javax.swing.JButton delete;
    private javax.swing.JButton generate;
    private javax.swing.JButton generate1;
    private javax.swing.JLabel instructions;
    private javax.swing.JTextArea instructionsList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField newName;
    private javax.swing.JTextField newTreeName;
    private javax.swing.JLabel relation;
    private javax.swing.JLabel selectedName;
    private javax.swing.JLabel selectedName1;
    private javax.swing.JPanel treeView;
    // End of variables declaration//GEN-END:variables
}
