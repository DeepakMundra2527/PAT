import { booleanAttribute, Component, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';
import { StorageService } from '../../services/storage/storage.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.scss'],
})
export class ResetPasswordComponent {
  resetPasswordForm!: FormGroup;
  newPasswordForm!: FormGroup; 
  isVerified = false; 
  errorMessage: string | null = null; 
  hidePassword = true;
  hidePassword1 = true;
  flag:any;

  securityQuestions = [
    { value: 'birthCity', viewValue: 'What city were you born in?' },
    { value: 'childhoodNickname', viewValue: 'What was your childhood nickname?' },
    { value: 'bestFriend', viewValue: 'Who is your best friend?' },
  ];

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private snackBar: MatSnackBar,
    private router: Router
  ) {
   
    this.resetPasswordForm = this.fb.group({
      email: [null, [Validators.required, Validators.email]],
      securityQuestion: [null, Validators.required],
      securityAnswer: [null, Validators.required]
    });

    this.newPasswordForm = this.fb.group({
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required, Validators.pattern(/^.{8,}$/)]],
      confirmPassword: [null, Validators.required],
    });
  }

  ngOnInit() { }

  togglePasswordVisibility1() {
    this.hidePassword1 = !this.hidePassword1;
  }

  togglePasswordVisibility() {
    this.hidePassword = !this.hidePassword;
  }

  onVerify() {
    const { email, securityQuestion, securityAnswer } = this.resetPasswordForm.value;

    this.verifySecurityQuestion(email, securityQuestion, securityAnswer);
  }

  private verifySecurityQuestion(email: string, question: string, answer: string): void {
    
    const reqObj={
      email: email,
      securityQuestion: question,
      securityAnswer: answer
    }
     this.authService.verify(reqObj).subscribe((res: any) => {
       console.log(res);
       if (res) {
        this.isVerified = true; 
        this.errorMessage = null; 
      } else {
        this.errorMessage = 'Incorrect answer. Please try again.'; 
      }
      });
  }

  
  onSubmit() {
    if (this.newPasswordForm.value.password === this.newPasswordForm.value.confirmPassword) {
      this.authService.reset(this.newPasswordForm.value).subscribe((res) => {
        this.router.navigateByUrl("/login");
        this.snackBar.open('Password reset successful!', 'Close', { duration: 5000 });
      });
    } else {
      this.errorMessage = 'Passwords do not match.';
    }
  }
}

