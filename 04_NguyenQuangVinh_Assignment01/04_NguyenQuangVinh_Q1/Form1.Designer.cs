namespace _04_NguyenQuangVinh_Q1
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            groupBox1 = new GroupBox();
            cbPosition = new ComboBox();
            rbtnFemale = new RadioButton();
            rbtnMale = new RadioButton();
            rbtnMaleOrFemale = new RadioButton();
            txtName = new TextBox();
            label2 = new Label();
            label1 = new Label();
            dgvData = new DataGridView();
            groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)dgvData).BeginInit();
            SuspendLayout();
            // 
            // groupBox1
            // 
            groupBox1.Controls.Add(cbPosition);
            groupBox1.Controls.Add(rbtnFemale);
            groupBox1.Controls.Add(rbtnMale);
            groupBox1.Controls.Add(rbtnMaleOrFemale);
            groupBox1.Controls.Add(txtName);
            groupBox1.Controls.Add(label2);
            groupBox1.Controls.Add(label1);
            groupBox1.Location = new Point(47, 32);
            groupBox1.Name = "groupBox1";
            groupBox1.Size = new Size(301, 386);
            groupBox1.TabIndex = 0;
            groupBox1.TabStop = false;
            groupBox1.Text = "Filter";
            // 
            // cbPosition
            // 
            cbPosition.FormattingEnabled = true;
            cbPosition.Items.AddRange(new object[] { "All Position", "Developer", "Leader", "Tester", "Manager" });
            cbPosition.Location = new Point(98, 157);
            cbPosition.Name = "cbPosition";
            cbPosition.Size = new Size(151, 28);
            cbPosition.TabIndex = 9;
            // 
            // rbtnFemale
            // 
            rbtnFemale.AutoSize = true;
            rbtnFemale.Location = new Point(210, 110);
            rbtnFemale.Name = "rbtnFemale";
            rbtnFemale.Size = new Size(78, 24);
            rbtnFemale.TabIndex = 8;
            rbtnFemale.TabStop = true;
            rbtnFemale.Text = "Female";
            rbtnFemale.UseVisualStyleBackColor = true;
            // 
            // rbtnMale
            // 
            rbtnMale.AutoSize = true;
            rbtnMale.Location = new Point(141, 110);
            rbtnMale.Name = "rbtnMale";
            rbtnMale.Size = new Size(63, 24);
            rbtnMale.TabIndex = 7;
            rbtnMale.TabStop = true;
            rbtnMale.Text = "Male";
            rbtnMale.UseVisualStyleBackColor = true;
            // 
            // rbtnMaleOrFemale
            // 
            rbtnMaleOrFemale.AutoSize = true;
            rbtnMaleOrFemale.Checked = true;
            rbtnMaleOrFemale.Location = new Point(18, 110);
            rbtnMaleOrFemale.Name = "rbtnMaleOrFemale";
            rbtnMaleOrFemale.Size = new Size(117, 24);
            rbtnMaleOrFemale.TabIndex = 6;
            rbtnMaleOrFemale.TabStop = true;
            rbtnMaleOrFemale.Text = "Male/Female";
            rbtnMaleOrFemale.UseVisualStyleBackColor = true;
            // 
            // txtName
            // 
            txtName.Location = new Point(98, 47);
            txtName.Name = "txtName";
            txtName.Size = new Size(190, 27);
            txtName.TabIndex = 2;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(18, 160);
            label2.Name = "label2";
            label2.Size = new Size(61, 20);
            label2.TabIndex = 1;
            label2.Text = "Position";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(18, 50);
            label1.Name = "label1";
            label1.Size = new Size(49, 20);
            label1.TabIndex = 0;
            label1.Text = "Name";
            // 
            // dgvData
            // 
            dgvData.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvData.Location = new Point(370, 43);
            dgvData.Name = "dgvData";
            dgvData.RowHeadersWidth = 51;
            dgvData.RowTemplate.Height = 29;
            dgvData.Size = new Size(732, 375);
            dgvData.TabIndex = 1;
            dgvData.CellClick += dgvData_CellClick;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1143, 450);
            Controls.Add(dgvData);
            Controls.Add(groupBox1);
            Name = "Form1";
            Text = "Form1";
            Load += Form1_Load;
            groupBox1.ResumeLayout(false);
            groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)dgvData).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private GroupBox groupBox1;
        private ComboBox cbPosition;
        private RadioButton rbtnFemale;
        private RadioButton rbtnMale;
        private RadioButton rbtnMaleOrFemale;
        private TextBox txtName;
        private Label label2;
        private Label label1;
        private DataGridView dgvData;
    }
}
