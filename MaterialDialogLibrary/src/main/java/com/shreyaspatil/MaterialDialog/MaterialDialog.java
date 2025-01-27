package com.shreyaspatil.MaterialDialog;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import androidx.appcompat.app.AlertDialog;

import com.shreyaspatil.MaterialDialog.model.DialogButton;

/**
 * Creates a Material Dialog with 2 buttons.
 * <p>
 * Use {@link Builder} to create a new instance.
 */
public class MaterialDialog extends AbstractDialog {


    protected MaterialDialog(@NonNull final Activity mActivity,
                             @NonNull String title,
                             @NonNull String message,
                             boolean mCancelable,
                             @NonNull DialogButton mPositiveButton,
                             @NonNull DialogButton mNegativeButton,
                             @RawRes int mAnimationResId,
                             @NonNull String mAnimationFile,
                             @NonNull Boolean mShowInLandscape,
                             @NonNull Integer mHeight
    ) {
        super(mActivity, title, message, mCancelable, mPositiveButton, mNegativeButton, mAnimationResId, mAnimationFile, mShowInLandscape, mHeight);

        // Init Dialog
        final AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);

        LayoutInflater inflater = mActivity.getLayoutInflater();

        View dialogView = createView(inflater, null);

        builder.setView(dialogView);

        // Set Cancelable property
        builder.setCancelable(mCancelable);

        // Create and show dialog
        mDialog = builder.create();
    }

    /**
     * Builder for {@link MaterialDialog}.
     */
    public static class Builder {
        private Activity activity;
        private String title;
        private String message;
        private boolean isCancelable;
        private DialogButton positiveButton;
        private DialogButton negativeButton;
        private int animationResId = NO_ANIMATION;
        private String animationFile;
        private Boolean showInLandscape = false;
        private Integer height = -1;

        /**
         * @param activity where Material Dialog is to be built.
         */
        public Builder(@NonNull Activity activity) {
            this.activity = activity;
        }

        /**
         * @param title Sets the Title of Material Dialog.
         * @return this, for chaining.
         */
        @NonNull
        public Builder setTitle(@NonNull String title) {
            this.title = title;
            return this;
        }

        /**
         * @param message Sets the Message of Material Dialog.
         * @return this, for chaining.
         */
        @NonNull
        public Builder setMessage(@NonNull String message) {
            this.message = message;
            return this;
        }

        /**
         * @param isCancelable Sets cancelable property of Material Dialog.
         * @return this, for chaining.
         */
        @NonNull
        public Builder setCancelable(boolean isCancelable) {
            this.isCancelable = isCancelable;
            return this;
        }

        /** Sets the Positive Button to Material Dialog without icon
         * @param name sets the name/label of button.
         * @param onClickListener interface for callback event on click of button.
         * @see this, for chaining.
         */
        @NonNull
        public Builder setPositiveButton(@NonNull String name, @NonNull OnClickListener onClickListener) {
            return setPositiveButton(name, NO_ICON, onClickListener);
        }

        /** Sets the Positive Button to Material Dialog with icon
         * @param name sets the name/label of button.
         * @param icon sets the resource icon for button.
         * @param onClickListener interface for callback event on click of button.
         * @return this, for chaining.
         */
        @NonNull
        public Builder setPositiveButton(@NonNull String name, int icon, @NonNull OnClickListener onClickListener) {
            positiveButton = new DialogButton(name, icon, onClickListener);
            return this;
        }

        /** Sets the Negative Button to Material Dialog without icon.
         * @param name sets the name/label of button.
         * @param onClickListener interface for callback event on click of button.
         * @see this, for chaining.
         */
        @NonNull
        public Builder setNegativeButton(@NonNull String name, @NonNull OnClickListener onClickListener) {
            return setNegativeButton(name, NO_ICON, onClickListener);
        }

        /** Sets the Negative Button to Material Dialog with icon
         * @param name sets the name/label of button.
         * @param icon sets the resource icon for button.
         * @param onClickListener interface for callback event on click of button.
         * @return this, for chaining.
         */
        @NonNull
        public Builder setNegativeButton(@NonNull String name, int icon, @NonNull OnClickListener onClickListener) {
            negativeButton = new DialogButton(name, icon, onClickListener);
            return this;
        }

        /** It sets the resource json to the {@link com.airbnb.lottie.LottieAnimationView}.
         * @param animationResId sets the resource to {@link com.airbnb.lottie.LottieAnimationView}.
         * @return this, for chaining.
         */
        @NonNull
        public Builder setAnimation(@RawRes int animationResId) {
            this.animationResId = animationResId;
            return this;
        }

        /** It sets the json file to the {@link com.airbnb.lottie.LottieAnimationView} from assets.
         * @param fileName sets the file from assets to {@link com.airbnb.lottie.LottieAnimationView}.
         * @return this, for chaining.
         */
        @NonNull
        public Builder setAnimation(@NonNull String fileName) {
            this.animationFile = fileName;
            return this;
        }

        /** It sets the showInLandscape property to allow or not the animation to be shown in landscape orientation
         *
         * @param showInLandscape sets the showInLandscape property
         * @return this, for chaining.
         */
        @NonNull
        public Builder setShowInLandscape(@NonNull Boolean showInLandscape) {
            this.showInLandscape = showInLandscape;
            return this;
        }

        /** It sets the showInLandscape property to allow or not the animation to be shown in landscape orientation
         *
         * @param height sets the height of the animation wrapper
         * @return this, for chaining.
         */
        @NonNull
        public Builder setAnimationHeight(@NonNull Integer height) {
            this.height = height;
            return this;
        }

        /**
         * Build the {@link MaterialDialog}.
         */
        @NonNull
        public MaterialDialog build() {
            return new MaterialDialog(activity, title, message, isCancelable, positiveButton, negativeButton, animationResId, animationFile, showInLandscape, height);
        }
    }
}
