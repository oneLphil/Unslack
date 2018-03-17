import {
  MatButtonModule,
  MatCheckboxModule,
  MatTabsModule,
  MatListModule,
  MatToolbarModule,
  MatCardModule,
  MatGridListModule,
  MatFormFieldModule,
  MatInputModule,
  MatDividerModule
} from '@angular/material';

import { NgModule } from '@angular/core';

@NgModule({
    imports: [MatButtonModule, MatButtonModule, MatCheckboxModule, MatTabsModule,
       MatListModule, MatToolbarModule, MatCardModule, MatGridListModule, MatFormFieldModule,
       MatInputModule, MatDividerModule],
    exports: [MatButtonModule, MatButtonModule, MatCheckboxModule, MatTabsModule,
       MatListModule, MatToolbarModule, MatCardModule, MatGridListModule, MatFormFieldModule,
       MatInputModule, MatDividerModule]
})

export class MaterialModule {}
