import {
  MatButtonModule,
  MatCheckboxModule,
  MatTabsModule,
  MatListModule,
  MatToolbarModule,
  MatCardModule,
  MatGridListModule,
  MatFormFieldModule,
  MatInputModule
} from '@angular/material';

import { NgModule } from '@angular/core';

@NgModule({
    imports: [MatButtonModule, MatButtonModule, MatCheckboxModule, MatTabsModule,
       MatListModule, MatToolbarModule, MatCardModule, MatGridListModule, MatFormFieldModule,
       MatInputModule],
    exports: [MatButtonModule, MatButtonModule, MatCheckboxModule, MatTabsModule,
       MatListModule, MatToolbarModule, MatCardModule, MatGridListModule, MatFormFieldModule,
       MatInputModule]
})

export class MaterialModule {}
